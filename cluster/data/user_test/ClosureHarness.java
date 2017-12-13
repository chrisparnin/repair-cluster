import org.junit.Test;
import static org.junit.Assert.*;

// from http://hyegar.com/2017/01/09/calling-google-closure/
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.google.javascript.jscomp.CompilationLevel;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.SourceFile;
import com.google.javascript.jscomp.JSError;
//import com.google.javascript.jscomp.CompilerOptions.LanguageMode;

public class ClosureHarness {
    public static String compile(String code) {
        return compile(code, true, null, null);
    }

    /**
     * @param code   JavaScript source code to compile.
     * @param simple Level of optimization
     * @return The compiled version of the code.
     */
    public static String compile(String code, boolean simple, String[] warnings, String[] errors) {
        Compiler compiler = new Compiler();
        CompilerOptions options = new CompilerOptions();
        if (null != warnings) {
            options.setCheckTypes(true);
        }

        // See :
        // closure-compiler/src/com/google/javascript/jscomp/CompilerOptions.java
        // lines 2864-2896
//        options.setLanguageIn(LanguageMode.ECMASCRIPT5);
//        options.setLanguageOut(LanguageMode.ECMASCRIPT5);

        if (simple) {
            CompilationLevel
                    .SIMPLE_OPTIMIZATIONS
                    .setOptionsForCompilationLevel(options);
        } else {
            CompilationLevel
                    .ADVANCED_OPTIMIZATIONS
                    .setOptionsForCompilationLevel(options);
        }

        List<SourceFile> list = new ArrayList<SourceFile>();

        /* Does not exist in d4j versions of closure */
        //        try {
        //            list =
        //                    CommandLineRunner
        //                            .getBuiltinExterns(CompilerOptions.Environment.BROWSER);
        //        } catch (IOException e) {
        //            System.out.println("Exception raised");
        //        }

        list.add(SourceFile.fromCode("input.js", code));
        compiler.compile(new ArrayList<SourceFile>(), list, options);

        if (null != warnings) {
            assertEquals(warnings.length, compiler.getWarningCount());
            JSError[] messages = compiler.getWarnings();
            for (int i = 0; i < warnings.length && i < compiler.getWarningCount(); i++) {
                assertEquals(warnings[i], messages[i].description);
            }
        } else {
            assertEquals(0, compiler.getWarningCount());
        }

        if (null != errors) {
            JSError[] errorsL = compiler.getErrors();
            for (int i = 0; i < errors.length && i < compiler.getErrorCount(); i++) {
                assertEquals(errors[i], errorsL[i].description);
            }
        } else {
            assertEquals(0, compiler.getErrorCount());
        }

        return compiler.toSource();
    }

    // from google
//void testTypes(String js, String[] warnings) throws Exception {
//    Node n = compiler.parseTestCode(js);
//    assertEquals(0, compiler.getErrorCount());
//    Node externsNode = new Node(Token.BLOCK);
//    Node externAndJsRoot = new Node(Token.BLOCK, externsNode, n);
//
//    makeTypeCheck().processForTesting(null, n);
//    assertEqua!= null) {
//      assertEquals(warnings.length, compiler.getWarningCount());
//      JSError[] messages = compiler.getWarnings();
//      for (int i = 0; i < warnings.length && i < compiler.getWarningCount();
//           i++) {
//        assertEquals(warnings[i], messages[i].description);
//      }
//    } else {
//      assertEquals(0, compiler.getWarningCount());
//    }ls(0, compiler.getErrorCount());
//    if (warnings
//  }

    public static void main(String[] args) {
        String compiled_code = compile("var a = 1 + 2; console.log(a)");
        System.out.println(compiled_code);
    }

    @Test
    public void dummyTest() {}
}
