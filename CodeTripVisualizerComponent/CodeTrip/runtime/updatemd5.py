# -*- coding: utf-8 -*-
"""
Created on Fri May 22 23:32:36 2011

@author: Searge
@version: v1.0
"""

import sys
import logging
from optparse import OptionParser

from commands import Commands, CLIENT, SERVER, CalledProcessError
from mcp import updatemd5_side


def main():
    parser = OptionParser(version='MCP %s' % Commands.fullversion())
    parser.add_option('-f', '--force', action='store_true', dest='force', help='force update', default=False)
    parser.add_option('-c', '--config', dest='config', help='additional configuration file')
    options, _ = parser.parse_args()
    updatemd5(options.config, options.force)


def updatemd5(conffile, force):
    try:
        commands = Commands(conffile)

        if (commands.checkmd5s(CLIENT) or commands.checkmd5s(SERVER)) and not force:
            print 'WARNING:'
            print 'The updatemd5 script is unsupported and should only be run in special'
            print 'cases, such as if there were compile errors in the last decompile which'
            print 'have now been corrected. It will reset the changed status of all classes'
            print 'for reobfuscation, and only classes modified afterwards will end up in'
            print 'the reobf directory.'
            print 'Only use this script if you absolutely know what you are doing, or when a'
            print 'MCP team member asks you to do so.'
            answer = raw_input('If you really want to update all classes, enter "Yes" ')
            if answer.lower() not in ['yes']:
                print 'You have not entered "Yes", aborting the update process'
                sys.exit(1)

        try:
            updatemd5_side(commands, CLIENT)
        except CalledProcessError:
            commands.logger.error('Client recompile failed, correct source then rerun updatemd5')
        try:
            updatemd5_side(commands, SERVER)
        except CalledProcessError:
            commands.logger.error('Server recompile failed, correct source then rerun updatemd5')
    except Exception:  # pylint: disable-msg=W0703
        logging.exception('FATAL ERROR')
        sys.exit(1)


if __name__ == '__main__':
    main()
