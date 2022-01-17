import java.io.BufferedWriter;
import java.io.IOException;

public class PseIntToJavaScript<T> extends PseIntBaseVisitor<T> {

    protected BufferedWriter writer;

    public PseIntToJavaScript(BufferedWriter writer) {
        this.writer = writer;
    }

    public void write(String toWrite) {
        try {
            writer.write(toWrite);
        } catch (IOException ioException) {
            System.out.println("An error occurred while writing translation");
            System.exit(-1);
        }
    }

    @Override
    public T visitS(PseIntParser.SContext ctx) {
        System.out.println("Hola");
        return null;
    }
}
