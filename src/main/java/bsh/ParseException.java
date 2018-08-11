/* Generated by: ParserGeneratorCC: Do not edit this line. ParseException.java Version 1.0 */
/* JavaCCOptions:KEEP_LINE_COLUMN=true */
/*****************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one                *
 * or more contributor license agreements.  See the NOTICE file              *
 * distributed with this work for additional information                     *
 * regarding copyright ownership.  The ASF licenses this file                *
 * to you under the Apache License, Version 2.0 (the                         *
 * "License"); you may not use this file except in compliance                *
 * with the License.  You may obtain a copy of the License at                *
 *                                                                           *
 *     http://www.apache.org/licenses/LICENSE-2.0                            *
 *                                                                           *
 * Unless required by applicable law or agreed to in writing,                *
 * software distributed under the License is distributed on an               *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY                    *
 * KIND, either express or implied.  See the License for the                 *
 * specific language governing permissions and limitations                   *
 * under the License.                                                        *
 *                                                                           *
 *                                                                           *
 * This file is part of the BeanShell Java Scripting distribution.           *
 * Documentation and updates may be found at http://www.beanshell.org/       *
 * Patrick Niemeyer (pat@pat.net)                                            *
 * Author of Learning Java, O'Reilly & Associates                            *
 *                                                                           *
 *****************************************************************************/
/*
    This file was auto generated, but has been modified since then.  If we
    need to regenerate it for some reason we should be careful to look at
    the notes below.

    All BeanShell modifications are demarcated by "Begin BeanShell
    Modification - ... " and "End BeanShell Modification - ..."

    Note: Please leave the ^M carriage return in the above auto-generated line
    or JavaCC will complain about version on Win systems.

    BeanShell Modification to generated file
    ----------------------------------------

    - Added sourceFile attribute
        setErrorSourceFile()
        getErrorSourceFile()
    - Modified getMessage() to print more tersely except on debug
      (removed "Was expecting one of...)
    - Added sourceFile info to getMessage()
    - Made ParseException extend EvalError
    - Modified constructors to use EvalError
    - Override
        getErrorLineNumber()
        getErrorText()
    - Add
        toString()
*/
package bsh;

/**
 * This exception is thrown when parse errors are encountered.
 * You can explicitly create objects of this exception type by
 * calling the method generateParseException in the generated
 * parser.
 *
 * You can modify this class to customize your error reporting
 * mechanisms so long as you retain the public fields.
 */
public class ParseException
// Begin BeanShell Modification - public, extend EvalError
                            extends EvalError {
// End BeanShell Modification - public, extend EvalError

    /**
     * The version identifier for this Serializable class.
     * Increment only if the <i>serialized</i> form of the
     * class changes.
     */
    private static final long serialVersionUID = 1L;

//Begin BeanShell Modification - sourceFile
    private static String sourceFile = "<unknown>";

    /**
     * Used to add source file info to exception
     * @param file source file
     */
    public void setErrorSourceFile(String file) {
        sourceFile = file;
    }

    /**
     * Accessor method to retrieve source file info.
     * {@inheritDoc}
     */
    @Override
    public String getErrorSourceFile() {
        return sourceFile;
    }
//End BeanShell Modification - sourceFile

    /**
     * The end of line string for this machine.
     */
    protected static String EOL = System.getProperty("line.separator", "\n");

    /**
     * This constructor is used by the method "generateParseException"
     * in the generated parser. Calling this constructor generates
     * a new object of this type with the fields "currentToken",
     * "expectedTokenSequences", and "tokenImage" set.
     */
    public ParseException(Token currentTokenVal, int[][] expectedTokenSequencesVal, String[] tokenImageVal) {
// Begin BeanShell Modification - constructor
        super(initialise(currentTokenVal, expectedTokenSequencesVal, tokenImageVal), null, null);
// End BeanShell Modification - constructor
        currentToken = currentTokenVal;
        expectedTokenSequences = expectedTokenSequencesVal;
        tokenImage = tokenImageVal;
    }

    /**
     * The following constructors are for use by you for whatever
     * purpose you can think of. Constructing the exception in this
     * manner makes the exception behave in the normal way - i.e., as
     * documented in the class "Throwable". The fields "errorToken",
     * "expectedTokenSequences", and "tokenImage" do not contain
     * relevant information. The JavaCC generated code does not use
     * these constructors.
     */
    public ParseException() {
// Begin BeanShell Modification - constructor
        super("", null, null);
// End BeanShell Modification - constructor
    }

    /** Constructor with message. */
    public ParseException(String message) {
// Begin BeanShell Modification - constructor
        // null node, null callstack, ParseException knows where the error is.
        super(message, null, null);
// End BeanShell Modification - constructor
    }

// Begin BeanShell Modification - constructor
    public ParseException(String message, Throwable cause) {
        super(message, null, null, cause);
    }
// End BeanShell Modification - constructor

    /**
     * This is the last token that has been consumed successfully. If
     * this object has been created due to a parse error, the token
     * followng this token will (therefore) be the first error token.
     */
    public Token currentToken;

    /**
     * Each entry in this array is an array of integers. Each array
     * of integers represents a sequence of tokens (by their ordinal
     * values) that is expected at this point of the parse.
     */
    public int[][] expectedTokenSequences;

    /**
     * This is a reference to the "tokenImage" array of the generated
     * parser within which the parse error occurred. This array is
     * defined in the generated ...Constants interface.
     */
    public String[] tokenImage;

    /**
     * It uses "currentToken" and "expectedTokenSequences" to generate a parse
     * error message and returns it. If this object has been created
     * due to a parse error, and you do not catch it (it gets thrown
     * from the parser) the correct error message
     * gets displayed.
     */
    private static String initialise(Token currentToken, int[][] expectedTokenSequences, String[] tokenImage) {

        StringBuilder expected = new StringBuilder();
        int maxSize = 0;
        for (int i = 0; i < expectedTokenSequences.length; i++) {
            if (maxSize < expectedTokenSequences[i].length) {
                maxSize = expectedTokenSequences[i].length;
            }
            for (int j = 0; j < expectedTokenSequences[i].length; j++) {
                expected.append(tokenImage[expectedTokenSequences[i][j]]).append(' ');
            }
            if (expectedTokenSequences[i][expectedTokenSequences[i].length - 1] != 0) {
                expected.append("...");
            }
            expected.append(EOL).append("    ");
        }
// Begin BeanShell Modification - added sourceFile info
        String retval = "In file: "+ sourceFile +" Encountered: ";
// End BeanShell Modification - added sourceFile info
        Token tok = currentToken.next;
        for (int i = 0; i < maxSize; i++) {
            if (i != 0)
                retval += " ";
            if (tok.kind == 0) {
                retval += tokenImage[0];
                break;
            }
            retval += " " + tokenImage[tok.kind];
            retval += " \"";
            retval += add_escapes(tok.image);
            retval += "\" ";
            tok = tok.next;
        }
        retval += " at line " + currentToken.next.beginLine + ", column " + currentToken.next.beginColumn;
        retval += "." + EOL;

// Begin BeanShell Modification - made conditional on debug
        if (Interpreter.DEBUG.get() && expectedTokenSequences.length != 0) {
            if (expectedTokenSequences.length == 1)
              retval += "Was expecting:" + EOL + "    ";
            else
              retval += "Was expecting one of:" + EOL + "    ";
            retval += expected.toString();
        }
// End BeanShell Modification - made conditional on debug

        return retval;
    }


    /**
     * Used to convert raw characters to their escaped version
     * when these raw version cannot be used as part of an ASCII
     * string literal.
     */
    static String add_escapes(String str) {
        StringBuilder retval = new StringBuilder();
        char ch;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '\b':
                    retval.append("\\b");
                    continue;
                case '\t':
                    retval.append("\\t");
                    continue;
                case '\n':
                    retval.append("\\n");
                    continue;
                case '\f':
                    retval.append("\\f");
                    continue;
                case '\r':
                    retval.append("\\r");
                    continue;
                case '\"':
                    retval.append("\\\"");
                    continue;
                case '\'':
                    retval.append("\\\'");
                    continue;
                case '\\':
                    retval.append("\\\\");
                    continue;
                default:
                    if ((ch = str.charAt(i)) < 0x20 || ch > 0x7e) {
                        String s = "0000" + Integer.toString(ch, 16);
                        retval.append("\\u").append(s.substring(s.length() - 4, s.length()));
                    } else {
                        retval.append(ch);
                    }
                    continue;
            }
        }
        return retval.toString();
    }


// Begin BeanShell Modification - override error methods and toString
    @Override
    public int getErrorLineNumber() {
        if (currentToken == null) {
            String message = getMessage();
            int index = message.indexOf(" at line ");
            if (index > -1) {
                message = message.substring(index + 9);
                index = message.indexOf(',');
                try {
                    if (index == -1) {
                        return Integer.parseInt(message);
                    }
                    return Integer.parseInt(message.substring(0, index));
                } catch (NumberFormatException e) {
                    // ignore, we have no valid line information, just return -1 for now
                }
            }
            return -1;
        }
        return currentToken.next.beginLine;
    }

    public String getErrorText() {
        // copied from generated getMessage()
        int maxSize = 0;
        for (int i = 0; i < expectedTokenSequences.length; i++) {
          if (maxSize < expectedTokenSequences[i].length)
            maxSize = expectedTokenSequences[i].length;
        }

        String retval = "In file: "+ sourceFile +" Encountered ";
        Token tok = currentToken.next;
        for (int i = 0; i < maxSize; i++) {
          if (i != 0) retval += " ";
          if (tok.kind == 0) {
            retval += tokenImage[0];
            break;
          }
          retval += " " + tokenImage[tok.kind];
          retval += " ";
          retval += add_escapes(tok.image);
          retval += " ";
          tok = tok.next;
        }
        retval += " at line " + currentToken.next.beginLine + ", column " + currentToken.next.beginColumn;
        retval += "." + EOL;

        return retval;
    }

    public String getMessage() {
        return initialise(currentToken, expectedTokenSequences, tokenImage);
    }
    public String getMessage(boolean debug) {
        return this.getMessage();
    }
    public String toString() {
        return getMessage();
    }

// End BeanShell Modification - override error methods and toString
}
/* JavaCC - OriginalChecksum=27381747f265700332a86284beda703e (do not edit this line) */
