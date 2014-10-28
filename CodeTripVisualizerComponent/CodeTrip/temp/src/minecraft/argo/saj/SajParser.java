// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package argo.saj;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

// Referenced classes of package argo.saj:
//            InvalidSyntaxException, PositionTrackingPushbackReader, JsonListener

public final class SajParser
{

    public SajParser()
    {
    }

    public void func_74552_a(Reader p_74552_1_, JsonListener p_74552_2_)
        throws IOException, InvalidSyntaxException
    {
        PositionTrackingPushbackReader positiontrackingpushbackreader = new PositionTrackingPushbackReader(p_74552_1_);
        char c = (char)positiontrackingpushbackreader.func_74564_a();
        switch(c)
        {
        case 123: // '{'
            positiontrackingpushbackreader.func_74567_a(c);
            p_74552_2_.func_74656_b();
            func_74555_b(positiontrackingpushbackreader, p_74552_2_);
            break;

        case 91: // '['
            positiontrackingpushbackreader.func_74567_a(c);
            p_74552_2_.func_74656_b();
            func_74559_a(positiontrackingpushbackreader, p_74552_2_);
            break;

        default:
            throw new InvalidSyntaxException((new StringBuilder()).append("Expected either [ or { but got [").append(c).append("].").toString(), positiontrackingpushbackreader);
        }
        int i = func_74553_l(positiontrackingpushbackreader);
        if(i != -1)
        {
            throw new InvalidSyntaxException((new StringBuilder()).append("Got unexpected trailing character [").append((char)i).append("].").toString(), positiontrackingpushbackreader);
        } else
        {
            p_74552_2_.func_74657_c();
            return;
        }
    }

    private void func_74559_a(PositionTrackingPushbackReader p_74559_1_, JsonListener p_74559_2_)
        throws IOException, InvalidSyntaxException
    {
        char c = (char)func_74553_l(p_74559_1_);
        if(c != '[')
        {
            throw new InvalidSyntaxException((new StringBuilder()).append("Expected object to start with [ but got [").append(c).append("].").toString(), p_74559_1_);
        }
        p_74559_2_.func_74652_d();
        char c1 = (char)func_74553_l(p_74559_1_);
        p_74559_1_.func_74567_a(c1);
        if(c1 != ']')
        {
            func_74545_d(p_74559_1_, p_74559_2_);
        }
        boolean flag = false;
        do
        {
            if(flag)
            {
                break;
            }
            char c2 = (char)func_74553_l(p_74559_1_);
            switch(c2)
            {
            case 44: // ','
                func_74545_d(p_74559_1_, p_74559_2_);
                break;

            case 93: // ']'
                flag = true;
                break;

            default:
                throw new InvalidSyntaxException((new StringBuilder()).append("Expected either , or ] but got [").append(c2).append("].").toString(), p_74559_1_);
            }
        } while(true);
        p_74559_2_.func_74655_e();
    }

    private void func_74555_b(PositionTrackingPushbackReader p_74555_1_, JsonListener p_74555_2_)
        throws IOException, InvalidSyntaxException
    {
        char c = (char)func_74553_l(p_74555_1_);
        if(c != '{')
        {
            throw new InvalidSyntaxException((new StringBuilder()).append("Expected object to start with { but got [").append(c).append("].").toString(), p_74555_1_);
        }
        p_74555_2_.func_74651_f();
        char c1 = (char)func_74553_l(p_74555_1_);
        p_74555_1_.func_74567_a(c1);
        if(c1 != '}')
        {
            func_74558_c(p_74555_1_, p_74555_2_);
        }
        boolean flag = false;
        do
        {
            if(flag)
            {
                break;
            }
            char c2 = (char)func_74553_l(p_74555_1_);
            switch(c2)
            {
            case 44: // ','
                func_74558_c(p_74555_1_, p_74555_2_);
                break;

            case 125: // '}'
                flag = true;
                break;

            default:
                throw new InvalidSyntaxException((new StringBuilder()).append("Expected either , or } but got [").append(c2).append("].").toString(), p_74555_1_);
            }
        } while(true);
        p_74555_2_.func_74653_g();
    }

    private void func_74558_c(PositionTrackingPushbackReader p_74558_1_, JsonListener p_74558_2_)
        throws IOException, InvalidSyntaxException
    {
        char c = (char)func_74553_l(p_74558_1_);
        if('"' != c)
        {
            throw new InvalidSyntaxException((new StringBuilder()).append("Expected object identifier to begin with [\"] but got [").append(c).append("].").toString(), p_74558_1_);
        }
        p_74558_1_.func_74567_a(c);
        p_74558_2_.func_74648_a(func_74548_i(p_74558_1_));
        char c1 = (char)func_74553_l(p_74558_1_);
        if(c1 != ':')
        {
            throw new InvalidSyntaxException((new StringBuilder()).append("Expected object identifier to be followed by : but got [").append(c1).append("].").toString(), p_74558_1_);
        } else
        {
            func_74545_d(p_74558_1_, p_74558_2_);
            p_74558_2_.func_74658_h();
            return;
        }
    }

    private void func_74545_d(PositionTrackingPushbackReader p_74545_1_, JsonListener p_74545_2_)
        throws IOException, InvalidSyntaxException
    {
        char c = (char)func_74553_l(p_74545_1_);
        switch(c)
        {
        case 34: // '"'
            p_74545_1_.func_74567_a(c);
            p_74545_2_.func_74647_c(func_74548_i(p_74545_1_));
            break;

        case 116: // 't'
            char ac[] = new char[3];
            int i = p_74545_1_.func_74565_b(ac);
            if(i != 3 || ac[0] != 'r' || ac[1] != 'u' || ac[2] != 'e')
            {
                p_74545_1_.func_74566_a(ac);
                throw new InvalidSyntaxException((new StringBuilder()).append("Expected 't' to be followed by [[r, u, e]], but got [").append(Arrays.toString(ac)).append("].").toString(), p_74545_1_);
            }
            p_74545_2_.func_74654_i();
            break;

        case 102: // 'f'
            char ac1[] = new char[4];
            int j = p_74545_1_.func_74565_b(ac1);
            if(j != 4 || ac1[0] != 'a' || ac1[1] != 'l' || ac1[2] != 's' || ac1[3] != 'e')
            {
                p_74545_1_.func_74566_a(ac1);
                throw new InvalidSyntaxException((new StringBuilder()).append("Expected 'f' to be followed by [[a, l, s, e]], but got [").append(Arrays.toString(ac1)).append("].").toString(), p_74545_1_);
            }
            p_74545_2_.func_74649_j();
            break;

        case 110: // 'n'
            char ac2[] = new char[3];
            int k = p_74545_1_.func_74565_b(ac2);
            if(k != 3 || ac2[0] != 'u' || ac2[1] != 'l' || ac2[2] != 'l')
            {
                p_74545_1_.func_74566_a(ac2);
                throw new InvalidSyntaxException((new StringBuilder()).append("Expected 'n' to be followed by [[u, l, l]], but got [").append(Arrays.toString(ac2)).append("].").toString(), p_74545_1_);
            }
            p_74545_2_.func_74646_k();
            break;

        case 45: // '-'
        case 48: // '0'
        case 49: // '1'
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        case 54: // '6'
        case 55: // '7'
        case 56: // '8'
        case 57: // '9'
            p_74545_1_.func_74567_a(c);
            p_74545_2_.func_74650_b(func_74549_a(p_74545_1_));
            break;

        case 123: // '{'
            p_74545_1_.func_74567_a(c);
            func_74555_b(p_74545_1_, p_74545_2_);
            break;

        case 91: // '['
            p_74545_1_.func_74567_a(c);
            func_74559_a(p_74545_1_, p_74545_2_);
            break;

        default:
            throw new InvalidSyntaxException((new StringBuilder()).append("Invalid character at start of value [").append(c).append("].").toString(), p_74545_1_);
        }
    }

    private String func_74549_a(PositionTrackingPushbackReader p_74549_1_)
        throws IOException, InvalidSyntaxException
    {
        StringBuilder stringbuilder = new StringBuilder();
        char c = (char)p_74549_1_.func_74564_a();
        if('-' == c)
        {
            stringbuilder.append('-');
        } else
        {
            p_74549_1_.func_74567_a(c);
        }
        stringbuilder.append(func_74557_b(p_74549_1_));
        return stringbuilder.toString();
    }

    private String func_74557_b(PositionTrackingPushbackReader p_74557_1_)
        throws IOException, InvalidSyntaxException
    {
        StringBuilder stringbuilder = new StringBuilder();
        char c = (char)p_74557_1_.func_74564_a();
        if('0' == c)
        {
            stringbuilder.append('0');
            stringbuilder.append(func_74556_f(p_74557_1_));
            stringbuilder.append(func_74546_g(p_74557_1_));
        } else
        {
            p_74557_1_.func_74567_a(c);
            stringbuilder.append(func_74560_c(p_74557_1_));
            stringbuilder.append(func_74551_e(p_74557_1_));
            stringbuilder.append(func_74556_f(p_74557_1_));
            stringbuilder.append(func_74546_g(p_74557_1_));
        }
        return stringbuilder.toString();
    }

    private char func_74560_c(PositionTrackingPushbackReader p_74560_1_)
        throws IOException, InvalidSyntaxException
    {
        char c1 = (char)p_74560_1_.func_74564_a();
        char c;
        switch(c1)
        {
        case 49: // '1'
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        case 54: // '6'
        case 55: // '7'
        case 56: // '8'
        case 57: // '9'
            c = c1;
            break;

        default:
            throw new InvalidSyntaxException((new StringBuilder()).append("Expected a digit 1 - 9 but got [").append(c1).append("].").toString(), p_74560_1_);
        }
        return c;
    }

    private char func_74554_d(PositionTrackingPushbackReader p_74554_1_)
        throws IOException, InvalidSyntaxException
    {
        char c1 = (char)p_74554_1_.func_74564_a();
        char c;
        switch(c1)
        {
        case 48: // '0'
        case 49: // '1'
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        case 54: // '6'
        case 55: // '7'
        case 56: // '8'
        case 57: // '9'
            c = c1;
            break;

        default:
            throw new InvalidSyntaxException((new StringBuilder()).append("Expected a digit 1 - 9 but got [").append(c1).append("].").toString(), p_74554_1_);
        }
        return c;
    }

    private String func_74551_e(PositionTrackingPushbackReader p_74551_1_)
        throws IOException
    {
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag = false;
        do
        {
            while(!flag) 
            {
                char c = (char)p_74551_1_.func_74564_a();
                switch(c)
                {
                case 48: // '0'
                case 49: // '1'
                case 50: // '2'
                case 51: // '3'
                case 52: // '4'
                case 53: // '5'
                case 54: // '6'
                case 55: // '7'
                case 56: // '8'
                case 57: // '9'
                    stringbuilder.append(c);
                    break;

                default:
                    flag = true;
                    p_74551_1_.func_74567_a(c);
                    break;
                }
            }
            return stringbuilder.toString();
        } while(true);
    }

    private String func_74556_f(PositionTrackingPushbackReader p_74556_1_)
        throws IOException, InvalidSyntaxException
    {
        StringBuilder stringbuilder = new StringBuilder();
        char c = (char)p_74556_1_.func_74564_a();
        if(c == '.')
        {
            stringbuilder.append('.');
            stringbuilder.append(func_74554_d(p_74556_1_));
            stringbuilder.append(func_74551_e(p_74556_1_));
        } else
        {
            p_74556_1_.func_74567_a(c);
        }
        return stringbuilder.toString();
    }

    private String func_74546_g(PositionTrackingPushbackReader p_74546_1_)
        throws IOException, InvalidSyntaxException
    {
        StringBuilder stringbuilder = new StringBuilder();
        char c = (char)p_74546_1_.func_74564_a();
        if(c == '.' || c == 'E')
        {
            stringbuilder.append('E');
            stringbuilder.append(func_74547_h(p_74546_1_));
            stringbuilder.append(func_74554_d(p_74546_1_));
            stringbuilder.append(func_74551_e(p_74546_1_));
        } else
        {
            p_74546_1_.func_74567_a(c);
        }
        return stringbuilder.toString();
    }

    private String func_74547_h(PositionTrackingPushbackReader p_74547_1_)
        throws IOException
    {
        StringBuilder stringbuilder = new StringBuilder();
        char c = (char)p_74547_1_.func_74564_a();
        if(c == '+' || c == '-')
        {
            stringbuilder.append(c);
        } else
        {
            p_74547_1_.func_74567_a(c);
        }
        return stringbuilder.toString();
    }

    private String func_74548_i(PositionTrackingPushbackReader p_74548_1_)
        throws IOException, InvalidSyntaxException
    {
        StringBuilder stringbuilder = new StringBuilder();
        char c = (char)p_74548_1_.func_74564_a();
        if('"' != c)
        {
            throw new InvalidSyntaxException((new StringBuilder()).append("Expected [\"] but got [").append(c).append("].").toString(), p_74548_1_);
        }
        boolean flag = false;
        do
        {
            if(flag)
            {
                break;
            }
            char c1 = (char)p_74548_1_.func_74564_a();
            switch(c1)
            {
            case 34: // '"'
                flag = true;
                break;

            case 92: // '\\'
                char c2 = func_74544_j(p_74548_1_);
                stringbuilder.append(c2);
                break;

            default:
                stringbuilder.append(c1);
                break;
            }
        } while(true);
        return stringbuilder.toString();
    }

    private char func_74544_j(PositionTrackingPushbackReader p_74544_1_)
        throws IOException, InvalidSyntaxException
    {
        char c1 = (char)p_74544_1_.func_74564_a();
        char c;
        switch(c1)
        {
        case 34: // '"'
            c = '"';
            break;

        case 92: // '\\'
            c = '\\';
            break;

        case 47: // '/'
            c = '/';
            break;

        case 98: // 'b'
            c = '\b';
            break;

        case 102: // 'f'
            c = '\f';
            break;

        case 110: // 'n'
            c = '\n';
            break;

        case 114: // 'r'
            c = '\r';
            break;

        case 116: // 't'
            c = '\t';
            break;

        case 117: // 'u'
            c = (char)func_74550_k(p_74544_1_);
            break;

        default:
            throw new InvalidSyntaxException((new StringBuilder()).append("Unrecognised escape character [").append(c1).append("].").toString(), p_74544_1_);
        }
        return c;
    }

    private int func_74550_k(PositionTrackingPushbackReader p_74550_1_)
        throws IOException, InvalidSyntaxException
    {
        char ac[] = new char[4];
        int i = p_74550_1_.func_74565_b(ac);
        if(i != 4)
        {
            throw new InvalidSyntaxException((new StringBuilder()).append("Expected a 4 digit hexidecimal number but got only [").append(i).append("], namely [").append(String.valueOf(ac, 0, i)).append("].").toString(), p_74550_1_);
        }
        int j;
        try
        {
            j = Integer.parseInt(String.valueOf(ac), 16);
        }
        catch(NumberFormatException numberformatexception)
        {
            p_74550_1_.func_74566_a(ac);
            throw new InvalidSyntaxException((new StringBuilder()).append("Unable to parse [").append(String.valueOf(ac)).append("] as a hexidecimal number.").toString(), numberformatexception, p_74550_1_);
        }
        return j;
    }

    private int func_74553_l(PositionTrackingPushbackReader p_74553_1_)
        throws IOException
    {
        boolean flag = false;
        int i;
        do
        {
            i = p_74553_1_.func_74564_a();
            switch(i)
            {
            default:
                flag = true;
                break;

            case 9: // '\t'
            case 10: // '\n'
            case 13: // '\r'
            case 32: // ' '
                break;
            }
        } while(!flag);
        return i;
    }
}
