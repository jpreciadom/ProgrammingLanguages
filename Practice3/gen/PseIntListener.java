// Generated from D:/General/Trabajos/ProgrammingLanguages/Practice3/Grammar\PseInt.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PseIntParser}.
 */
public interface PseIntListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PseIntParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(PseIntParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseIntParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(PseIntParser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link PseIntParser#subprocess}.
	 * @param ctx the parse tree
	 */
	void enterSubprocess(PseIntParser.SubprocessContext ctx);
	/**
	 * Exit a parse tree produced by {@link PseIntParser#subprocess}.
	 * @param ctx the parse tree
	 */
	void exitSubprocess(PseIntParser.SubprocessContext ctx);
}