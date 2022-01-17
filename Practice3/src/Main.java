import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CommonTokenStream tokens = new CommonTokenStream(new PseIntLexer(CharStreams.fromFileName("input/input.psc")));
        PseIntParser pseIntParser = new PseIntParser(tokens);
        ParseTree parseTree = pseIntParser.s();

        PseIntToJavaScript<Object> loader = new PseIntToJavaScript<>(new BufferedWriter(new FileWriter("output/output.js")));
        loader.visit(parseTree);
    }
}
