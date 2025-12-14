package de.evoal.languages.model.generator.dsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.evoal.languages.model.generator.dsl.services.GeneratorDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalGeneratorDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_DOUBLE", "RULE_INT", "RULE_QUOTED_ID", "RULE_ID", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'{'", "'}'", "'pipeline'", "'['", "']'", "'step'", "'component'", "'reads'", "','", "';'", "'writes'", "'begin'", "'end'", "'for'", "'in'", "'to'", "'increment'", "'by'", "'write'", "'with'", "'samples'", "'from'", "'executing'", "'('", "')'", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'data'", "'instance'", "':='", "'true'", "'false'", "'@'", "':'", "'optional'", "'enum'", "'literal'", "'string'", "'expression'", "'int'", "'real'", "'boolean'", "'void'", "'array'", "'import'", "'.'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=8;
    public static final int RULE_QUOTED_ID=7;
    public static final int RULE_DIGIT=9;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_EXPONENT=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__95=95;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_DOUBLE=5;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalGeneratorDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGeneratorDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGeneratorDSLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalGeneratorDSL.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private GeneratorDSLGrammarAccess grammarAccess;

        public InternalGeneratorDSLParser(TokenStream input, GeneratorDSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "GeneratorModuleRule";
       	}

       	@Override
       	protected GeneratorDSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleGeneratorModuleRule"
    // InternalGeneratorDSL.g:71:1: entryRuleGeneratorModuleRule returns [EObject current=null] : iv_ruleGeneratorModuleRule= ruleGeneratorModuleRule EOF ;
    public final EObject entryRuleGeneratorModuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratorModuleRule = null;


        try {
            // InternalGeneratorDSL.g:71:60: (iv_ruleGeneratorModuleRule= ruleGeneratorModuleRule EOF )
            // InternalGeneratorDSL.g:72:2: iv_ruleGeneratorModuleRule= ruleGeneratorModuleRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGeneratorModuleRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGeneratorModuleRule=ruleGeneratorModuleRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGeneratorModuleRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneratorModuleRule"


    // $ANTLR start "ruleGeneratorModuleRule"
    // InternalGeneratorDSL.g:78:1: ruleGeneratorModuleRule returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( (lv_pipelines_4_0= rulePipelineDefinitionRule ) )* ( (lv_body_5_0= ruleBodyRule ) ) otherlv_6= '}' ) ;
    public final EObject ruleGeneratorModuleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_imports_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_pipelines_4_0 = null;

        EObject lv_body_5_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:84:2: ( ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( (lv_pipelines_4_0= rulePipelineDefinitionRule ) )* ( (lv_body_5_0= ruleBodyRule ) ) otherlv_6= '}' ) )
            // InternalGeneratorDSL.g:85:2: ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( (lv_pipelines_4_0= rulePipelineDefinitionRule ) )* ( (lv_body_5_0= ruleBodyRule ) ) otherlv_6= '}' )
            {
            // InternalGeneratorDSL.g:85:2: ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( (lv_pipelines_4_0= rulePipelineDefinitionRule ) )* ( (lv_body_5_0= ruleBodyRule ) ) otherlv_6= '}' )
            // InternalGeneratorDSL.g:86:3: ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( (lv_pipelines_4_0= rulePipelineDefinitionRule ) )* ( (lv_body_5_0= ruleBodyRule ) ) otherlv_6= '}'
            {
            // InternalGeneratorDSL.g:86:3: ( (lv_imports_0_0= ruleImportRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==63) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalGeneratorDSL.g:87:4: (lv_imports_0_0= ruleImportRule )
            	    {
            	    // InternalGeneratorDSL.g:87:4: (lv_imports_0_0= ruleImportRule )
            	    // InternalGeneratorDSL.g:88:5: lv_imports_0_0= ruleImportRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getGeneratorModuleRuleAccess().getImportsImportRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImportRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getGeneratorModuleRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"imports",
            	      						lv_imports_0_0,
            	      						"de.evoal.languages.model.base.dsl.BaseLanguage.ImportRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_1=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getGeneratorModuleRuleAccess().getModuleKeyword_1());
              		
            }
            // InternalGeneratorDSL.g:109:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalGeneratorDSL.g:110:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalGeneratorDSL.g:110:4: (lv_name_2_0= ruleQualifiedName )
            // InternalGeneratorDSL.g:111:5: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getGeneratorModuleRuleAccess().getNameQualifiedNameParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getGeneratorModuleRuleRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_2_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.QualifiedName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getGeneratorModuleRuleAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalGeneratorDSL.g:132:3: ( (lv_pipelines_4_0= rulePipelineDefinitionRule ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalGeneratorDSL.g:133:4: (lv_pipelines_4_0= rulePipelineDefinitionRule )
            	    {
            	    // InternalGeneratorDSL.g:133:4: (lv_pipelines_4_0= rulePipelineDefinitionRule )
            	    // InternalGeneratorDSL.g:134:5: lv_pipelines_4_0= rulePipelineDefinitionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getGeneratorModuleRuleAccess().getPipelinesPipelineDefinitionRuleParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_pipelines_4_0=rulePipelineDefinitionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getGeneratorModuleRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"pipelines",
            	      						lv_pipelines_4_0,
            	      						"de.evoal.languages.model.generator.dsl.GeneratorDSL.PipelineDefinitionRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalGeneratorDSL.g:151:3: ( (lv_body_5_0= ruleBodyRule ) )
            // InternalGeneratorDSL.g:152:4: (lv_body_5_0= ruleBodyRule )
            {
            // InternalGeneratorDSL.g:152:4: (lv_body_5_0= ruleBodyRule )
            // InternalGeneratorDSL.g:153:5: lv_body_5_0= ruleBodyRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getGeneratorModuleRuleAccess().getBodyBodyRuleParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_7);
            lv_body_5_0=ruleBodyRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getGeneratorModuleRuleRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_5_0,
              						"de.evoal.languages.model.generator.dsl.GeneratorDSL.BodyRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_6=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getGeneratorModuleRuleAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGeneratorModuleRule"


    // $ANTLR start "entryRulePipelineDefinitionRule"
    // InternalGeneratorDSL.g:178:1: entryRulePipelineDefinitionRule returns [EObject current=null] : iv_rulePipelineDefinitionRule= rulePipelineDefinitionRule EOF ;
    public final EObject entryRulePipelineDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineDefinitionRule = null;


        try {
            // InternalGeneratorDSL.g:178:63: (iv_rulePipelineDefinitionRule= rulePipelineDefinitionRule EOF )
            // InternalGeneratorDSL.g:179:2: iv_rulePipelineDefinitionRule= rulePipelineDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPipelineDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePipelineDefinitionRule=rulePipelineDefinitionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePipelineDefinitionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePipelineDefinitionRule"


    // $ANTLR start "rulePipelineDefinitionRule"
    // InternalGeneratorDSL.g:185:1: rulePipelineDefinitionRule returns [EObject current=null] : (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStepRule ) )* otherlv_4= ']' ) ;
    public final EObject rulePipelineDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_steps_3_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:191:2: ( (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStepRule ) )* otherlv_4= ']' ) )
            // InternalGeneratorDSL.g:192:2: (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStepRule ) )* otherlv_4= ']' )
            {
            // InternalGeneratorDSL.g:192:2: (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStepRule ) )* otherlv_4= ']' )
            // InternalGeneratorDSL.g:193:3: otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStepRule ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPipelineDefinitionRuleAccess().getPipelineKeyword_0());
              		
            }
            // InternalGeneratorDSL.g:197:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalGeneratorDSL.g:198:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalGeneratorDSL.g:198:4: (lv_name_1_0= ruleStringOrId )
            // InternalGeneratorDSL.g:199:5: lv_name_1_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPipelineDefinitionRuleAccess().getNameStringOrIdParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_name_1_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPipelineDefinitionRuleRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.StringOrId");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPipelineDefinitionRuleAccess().getLeftSquareBracketKeyword_2());
              		
            }
            // InternalGeneratorDSL.g:220:3: ( (lv_steps_3_0= ruleStepRule ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18||LA3_0==21) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalGeneratorDSL.g:221:4: (lv_steps_3_0= ruleStepRule )
            	    {
            	    // InternalGeneratorDSL.g:221:4: (lv_steps_3_0= ruleStepRule )
            	    // InternalGeneratorDSL.g:222:5: lv_steps_3_0= ruleStepRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getPipelineDefinitionRuleAccess().getStepsStepRuleParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_steps_3_0=ruleStepRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getPipelineDefinitionRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"steps",
            	      						lv_steps_3_0,
            	      						"de.evoal.languages.model.generator.dsl.GeneratorDSL.StepRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_4=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getPipelineDefinitionRuleAccess().getRightSquareBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePipelineDefinitionRule"


    // $ANTLR start "entryRuleStepRule"
    // InternalGeneratorDSL.g:247:1: entryRuleStepRule returns [EObject current=null] : iv_ruleStepRule= ruleStepRule EOF ;
    public final EObject entryRuleStepRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStepRule = null;


        try {
            // InternalGeneratorDSL.g:247:49: (iv_ruleStepRule= ruleStepRule EOF )
            // InternalGeneratorDSL.g:248:2: iv_ruleStepRule= ruleStepRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStepRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStepRule=ruleStepRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStepRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStepRule"


    // $ANTLR start "ruleStepRule"
    // InternalGeneratorDSL.g:254:1: ruleStepRule returns [EObject current=null] : (this_ConcreteStepRule_0= ruleConcreteStepRule | this_PipelineStepRule_1= rulePipelineStepRule ) ;
    public final EObject ruleStepRule() throws RecognitionException {
        EObject current = null;

        EObject this_ConcreteStepRule_0 = null;

        EObject this_PipelineStepRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:260:2: ( (this_ConcreteStepRule_0= ruleConcreteStepRule | this_PipelineStepRule_1= rulePipelineStepRule ) )
            // InternalGeneratorDSL.g:261:2: (this_ConcreteStepRule_0= ruleConcreteStepRule | this_PipelineStepRule_1= rulePipelineStepRule )
            {
            // InternalGeneratorDSL.g:261:2: (this_ConcreteStepRule_0= ruleConcreteStepRule | this_PipelineStepRule_1= rulePipelineStepRule )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21) ) {
                alt4=1;
            }
            else if ( (LA4_0==18) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalGeneratorDSL.g:262:3: this_ConcreteStepRule_0= ruleConcreteStepRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStepRuleAccess().getConcreteStepRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ConcreteStepRule_0=ruleConcreteStepRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConcreteStepRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:274:3: this_PipelineStepRule_1= rulePipelineStepRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStepRuleAccess().getPipelineStepRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PipelineStepRule_1=rulePipelineStepRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PipelineStepRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStepRule"


    // $ANTLR start "entryRuleConcreteStepRule"
    // InternalGeneratorDSL.g:289:1: entryRuleConcreteStepRule returns [EObject current=null] : iv_ruleConcreteStepRule= ruleConcreteStepRule EOF ;
    public final EObject entryRuleConcreteStepRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteStepRule = null;


        try {
            // InternalGeneratorDSL.g:289:57: (iv_ruleConcreteStepRule= ruleConcreteStepRule EOF )
            // InternalGeneratorDSL.g:290:2: iv_ruleConcreteStepRule= ruleConcreteStepRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConcreteStepRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConcreteStepRule=ruleConcreteStepRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConcreteStepRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcreteStepRule"


    // $ANTLR start "ruleConcreteStepRule"
    // InternalGeneratorDSL.g:296:1: ruleConcreteStepRule returns [EObject current=null] : (otherlv_0= 'step' otherlv_1= '{' otherlv_2= 'component' ( (lv_instance_3_0= ruleInstanceLiteralRule ) ) (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )? (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )? otherlv_18= '}' ) ;
    public final EObject ruleConcreteStepRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        EObject lv_instance_3_0 = null;

        EObject lv_reads_6_0 = null;

        EObject lv_reads_8_0 = null;

        EObject lv_writes_13_0 = null;

        EObject lv_writes_15_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:302:2: ( (otherlv_0= 'step' otherlv_1= '{' otherlv_2= 'component' ( (lv_instance_3_0= ruleInstanceLiteralRule ) ) (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )? (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )? otherlv_18= '}' ) )
            // InternalGeneratorDSL.g:303:2: (otherlv_0= 'step' otherlv_1= '{' otherlv_2= 'component' ( (lv_instance_3_0= ruleInstanceLiteralRule ) ) (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )? (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )? otherlv_18= '}' )
            {
            // InternalGeneratorDSL.g:303:2: (otherlv_0= 'step' otherlv_1= '{' otherlv_2= 'component' ( (lv_instance_3_0= ruleInstanceLiteralRule ) ) (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )? (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )? otherlv_18= '}' )
            // InternalGeneratorDSL.g:304:3: otherlv_0= 'step' otherlv_1= '{' otherlv_2= 'component' ( (lv_instance_3_0= ruleInstanceLiteralRule ) ) (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )? (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )? otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConcreteStepRuleAccess().getStepKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,16,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getConcreteStepRuleAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConcreteStepRuleAccess().getComponentKeyword_2());
              		
            }
            // InternalGeneratorDSL.g:316:3: ( (lv_instance_3_0= ruleInstanceLiteralRule ) )
            // InternalGeneratorDSL.g:317:4: (lv_instance_3_0= ruleInstanceLiteralRule )
            {
            // InternalGeneratorDSL.g:317:4: (lv_instance_3_0= ruleInstanceLiteralRule )
            // InternalGeneratorDSL.g:318:5: lv_instance_3_0= ruleInstanceLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConcreteStepRuleAccess().getInstanceInstanceLiteralRuleParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_11);
            lv_instance_3_0=ruleInstanceLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConcreteStepRuleRule());
              					}
              					set(
              						current,
              						"instance",
              						lv_instance_3_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.InstanceLiteralRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGeneratorDSL.g:335:3: (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==23) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalGeneratorDSL.g:336:4: otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';'
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getConcreteStepRuleAccess().getReadsKeyword_4_0());
                      			
                    }
                    otherlv_5=(Token)match(input,19,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getConcreteStepRuleAccess().getLeftSquareBracketKeyword_4_1());
                      			
                    }
                    // InternalGeneratorDSL.g:344:4: ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==46) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalGeneratorDSL.g:345:5: ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )*
                            {
                            // InternalGeneratorDSL.g:345:5: ( (lv_reads_6_0= ruleBaseDataReferenceRule ) )
                            // InternalGeneratorDSL.g:346:6: (lv_reads_6_0= ruleBaseDataReferenceRule )
                            {
                            // InternalGeneratorDSL.g:346:6: (lv_reads_6_0= ruleBaseDataReferenceRule )
                            // InternalGeneratorDSL.g:347:7: lv_reads_6_0= ruleBaseDataReferenceRule
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getConcreteStepRuleAccess().getReadsBaseDataReferenceRuleParserRuleCall_4_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_13);
                            lv_reads_6_0=ruleBaseDataReferenceRule();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getConcreteStepRuleRule());
                              							}
                              							add(
                              								current,
                              								"reads",
                              								lv_reads_6_0,
                              								"de.evoal.languages.model.base.dsl.BaseLanguage.BaseDataReferenceRule");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalGeneratorDSL.g:364:5: (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )*
                            loop5:
                            do {
                                int alt5=2;
                                int LA5_0 = input.LA(1);

                                if ( (LA5_0==24) ) {
                                    alt5=1;
                                }


                                switch (alt5) {
                            	case 1 :
                            	    // InternalGeneratorDSL.g:365:6: otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,24,FOLLOW_14); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_7, grammarAccess.getConcreteStepRuleAccess().getCommaKeyword_4_2_1_0());
                            	      					
                            	    }
                            	    // InternalGeneratorDSL.g:369:6: ( (lv_reads_8_0= ruleBaseDataReferenceRule ) )
                            	    // InternalGeneratorDSL.g:370:7: (lv_reads_8_0= ruleBaseDataReferenceRule )
                            	    {
                            	    // InternalGeneratorDSL.g:370:7: (lv_reads_8_0= ruleBaseDataReferenceRule )
                            	    // InternalGeneratorDSL.g:371:8: lv_reads_8_0= ruleBaseDataReferenceRule
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getConcreteStepRuleAccess().getReadsBaseDataReferenceRuleParserRuleCall_4_2_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_13);
                            	    lv_reads_8_0=ruleBaseDataReferenceRule();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getConcreteStepRuleRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"reads",
                            	      									lv_reads_8_0,
                            	      									"de.evoal.languages.model.base.dsl.BaseLanguage.BaseDataReferenceRule");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop5;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,20,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getConcreteStepRuleAccess().getRightSquareBracketKeyword_4_3());
                      			
                    }
                    otherlv_10=(Token)match(input,25,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getConcreteStepRuleAccess().getSemicolonKeyword_4_4());
                      			
                    }

                    }
                    break;

            }

            // InternalGeneratorDSL.g:399:3: (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==26) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalGeneratorDSL.g:400:4: otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';'
                    {
                    otherlv_11=(Token)match(input,26,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getConcreteStepRuleAccess().getWritesKeyword_5_0());
                      			
                    }
                    otherlv_12=(Token)match(input,19,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getConcreteStepRuleAccess().getLeftSquareBracketKeyword_5_1());
                      			
                    }
                    // InternalGeneratorDSL.g:408:4: ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==46) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalGeneratorDSL.g:409:5: ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )*
                            {
                            // InternalGeneratorDSL.g:409:5: ( (lv_writes_13_0= ruleBaseDataReferenceRule ) )
                            // InternalGeneratorDSL.g:410:6: (lv_writes_13_0= ruleBaseDataReferenceRule )
                            {
                            // InternalGeneratorDSL.g:410:6: (lv_writes_13_0= ruleBaseDataReferenceRule )
                            // InternalGeneratorDSL.g:411:7: lv_writes_13_0= ruleBaseDataReferenceRule
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getConcreteStepRuleAccess().getWritesBaseDataReferenceRuleParserRuleCall_5_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_13);
                            lv_writes_13_0=ruleBaseDataReferenceRule();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getConcreteStepRuleRule());
                              							}
                              							add(
                              								current,
                              								"writes",
                              								lv_writes_13_0,
                              								"de.evoal.languages.model.base.dsl.BaseLanguage.BaseDataReferenceRule");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalGeneratorDSL.g:428:5: (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0==24) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // InternalGeneratorDSL.g:429:6: otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) )
                            	    {
                            	    otherlv_14=(Token)match(input,24,FOLLOW_14); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_14, grammarAccess.getConcreteStepRuleAccess().getCommaKeyword_5_2_1_0());
                            	      					
                            	    }
                            	    // InternalGeneratorDSL.g:433:6: ( (lv_writes_15_0= ruleBaseDataReferenceRule ) )
                            	    // InternalGeneratorDSL.g:434:7: (lv_writes_15_0= ruleBaseDataReferenceRule )
                            	    {
                            	    // InternalGeneratorDSL.g:434:7: (lv_writes_15_0= ruleBaseDataReferenceRule )
                            	    // InternalGeneratorDSL.g:435:8: lv_writes_15_0= ruleBaseDataReferenceRule
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getConcreteStepRuleAccess().getWritesBaseDataReferenceRuleParserRuleCall_5_2_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_13);
                            	    lv_writes_15_0=ruleBaseDataReferenceRule();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getConcreteStepRuleRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"writes",
                            	      									lv_writes_15_0,
                            	      									"de.evoal.languages.model.base.dsl.BaseLanguage.BaseDataReferenceRule");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_16=(Token)match(input,20,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getConcreteStepRuleAccess().getRightSquareBracketKeyword_5_3());
                      			
                    }
                    otherlv_17=(Token)match(input,25,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getConcreteStepRuleAccess().getSemicolonKeyword_5_4());
                      			
                    }

                    }
                    break;

            }

            otherlv_18=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_18, grammarAccess.getConcreteStepRuleAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcreteStepRule"


    // $ANTLR start "entryRulePipelineStepRule"
    // InternalGeneratorDSL.g:471:1: entryRulePipelineStepRule returns [EObject current=null] : iv_rulePipelineStepRule= rulePipelineStepRule EOF ;
    public final EObject entryRulePipelineStepRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStepRule = null;


        try {
            // InternalGeneratorDSL.g:471:57: (iv_rulePipelineStepRule= rulePipelineStepRule EOF )
            // InternalGeneratorDSL.g:472:2: iv_rulePipelineStepRule= rulePipelineStepRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPipelineStepRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePipelineStepRule=rulePipelineStepRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePipelineStepRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePipelineStepRule"


    // $ANTLR start "rulePipelineStepRule"
    // InternalGeneratorDSL.g:478:1: rulePipelineStepRule returns [EObject current=null] : (otherlv_0= 'pipeline' ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePipelineStepRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:484:2: ( (otherlv_0= 'pipeline' ( ( ruleQualifiedName ) ) ) )
            // InternalGeneratorDSL.g:485:2: (otherlv_0= 'pipeline' ( ( ruleQualifiedName ) ) )
            {
            // InternalGeneratorDSL.g:485:2: (otherlv_0= 'pipeline' ( ( ruleQualifiedName ) ) )
            // InternalGeneratorDSL.g:486:3: otherlv_0= 'pipeline' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPipelineStepRuleAccess().getPipelineKeyword_0());
              		
            }
            // InternalGeneratorDSL.g:490:3: ( ( ruleQualifiedName ) )
            // InternalGeneratorDSL.g:491:4: ( ruleQualifiedName )
            {
            // InternalGeneratorDSL.g:491:4: ( ruleQualifiedName )
            // InternalGeneratorDSL.g:492:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPipelineStepRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPipelineStepRuleAccess().getDefinitionPipelineDefinitionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePipelineStepRule"


    // $ANTLR start "entryRuleBodyRule"
    // InternalGeneratorDSL.g:513:1: entryRuleBodyRule returns [EObject current=null] : iv_ruleBodyRule= ruleBodyRule EOF ;
    public final EObject entryRuleBodyRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBodyRule = null;


        try {
            // InternalGeneratorDSL.g:513:49: (iv_ruleBodyRule= ruleBodyRule EOF )
            // InternalGeneratorDSL.g:514:2: iv_ruleBodyRule= ruleBodyRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBodyRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBodyRule=ruleBodyRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBodyRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBodyRule"


    // $ANTLR start "ruleBodyRule"
    // InternalGeneratorDSL.g:520:1: ruleBodyRule returns [EObject current=null] : ( () otherlv_1= 'begin' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= 'end' ) ;
    public final EObject ruleBodyRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:526:2: ( ( () otherlv_1= 'begin' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= 'end' ) )
            // InternalGeneratorDSL.g:527:2: ( () otherlv_1= 'begin' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= 'end' )
            {
            // InternalGeneratorDSL.g:527:2: ( () otherlv_1= 'begin' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= 'end' )
            // InternalGeneratorDSL.g:528:3: () otherlv_1= 'begin' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= 'end'
            {
            // InternalGeneratorDSL.g:528:3: ()
            // InternalGeneratorDSL.g:529:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBodyRuleAccess().getBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,27,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBodyRuleAccess().getBeginKeyword_1());
              		
            }
            // InternalGeneratorDSL.g:542:3: ( (lv_statements_2_0= ruleStatementRule ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=RULE_QUOTED_ID && LA11_0<=RULE_ID)||LA11_0==29||LA11_0==34) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalGeneratorDSL.g:543:4: (lv_statements_2_0= ruleStatementRule )
            	    {
            	    // InternalGeneratorDSL.g:543:4: (lv_statements_2_0= ruleStatementRule )
            	    // InternalGeneratorDSL.g:544:5: lv_statements_2_0= ruleStatementRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBodyRuleAccess().getStatementsStatementRuleParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_17);
            	    lv_statements_2_0=ruleStatementRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getBodyRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_2_0,
            	      						"de.evoal.languages.model.generator.dsl.GeneratorDSL.StatementRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_3=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getBodyRuleAccess().getEndKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBodyRule"


    // $ANTLR start "entryRuleStatementRule"
    // InternalGeneratorDSL.g:569:1: entryRuleStatementRule returns [EObject current=null] : iv_ruleStatementRule= ruleStatementRule EOF ;
    public final EObject entryRuleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementRule = null;


        try {
            // InternalGeneratorDSL.g:569:54: (iv_ruleStatementRule= ruleStatementRule EOF )
            // InternalGeneratorDSL.g:570:2: iv_ruleStatementRule= ruleStatementRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatementRule=ruleStatementRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatementRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatementRule"


    // $ANTLR start "ruleStatementRule"
    // InternalGeneratorDSL.g:576:1: ruleStatementRule returns [EObject current=null] : (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule | this_CallBuiltInFunctionRule_2= ruleCallBuiltInFunctionRule ) ;
    public final EObject ruleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject this_ForStatementRule_0 = null;

        EObject this_ApplyStatementRule_1 = null;

        EObject this_CallBuiltInFunctionRule_2 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:582:2: ( (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule | this_CallBuiltInFunctionRule_2= ruleCallBuiltInFunctionRule ) )
            // InternalGeneratorDSL.g:583:2: (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule | this_CallBuiltInFunctionRule_2= ruleCallBuiltInFunctionRule )
            {
            // InternalGeneratorDSL.g:583:2: (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule | this_CallBuiltInFunctionRule_2= ruleCallBuiltInFunctionRule )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt12=1;
                }
                break;
            case 34:
                {
                alt12=2;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt12=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalGeneratorDSL.g:584:3: this_ForStatementRule_0= ruleForStatementRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementRuleAccess().getForStatementRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ForStatementRule_0=ruleForStatementRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ForStatementRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:596:3: this_ApplyStatementRule_1= ruleApplyStatementRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementRuleAccess().getApplyStatementRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ApplyStatementRule_1=ruleApplyStatementRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ApplyStatementRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:608:3: this_CallBuiltInFunctionRule_2= ruleCallBuiltInFunctionRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementRuleAccess().getCallBuiltInFunctionRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CallBuiltInFunctionRule_2=ruleCallBuiltInFunctionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CallBuiltInFunctionRule_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatementRule"


    // $ANTLR start "entryRuleForStatementRule"
    // InternalGeneratorDSL.g:623:1: entryRuleForStatementRule returns [EObject current=null] : iv_ruleForStatementRule= ruleForStatementRule EOF ;
    public final EObject entryRuleForStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatementRule = null;


        try {
            // InternalGeneratorDSL.g:623:57: (iv_ruleForStatementRule= ruleForStatementRule EOF )
            // InternalGeneratorDSL.g:624:2: iv_ruleForStatementRule= ruleForStatementRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForStatementRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleForStatementRule=ruleForStatementRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForStatementRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForStatementRule"


    // $ANTLR start "ruleForStatementRule"
    // InternalGeneratorDSL.g:630:1: ruleForStatementRule returns [EObject current=null] : (otherlv_0= 'for' ( (lv_var_1_0= ruleNamedVariableRule ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) ( (lv_body_4_0= ruleBodyRule ) ) ) ;
    public final EObject ruleForStatementRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_var_1_0 = null;

        EObject lv_range_3_0 = null;

        EObject lv_body_4_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:636:2: ( (otherlv_0= 'for' ( (lv_var_1_0= ruleNamedVariableRule ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) ( (lv_body_4_0= ruleBodyRule ) ) ) )
            // InternalGeneratorDSL.g:637:2: (otherlv_0= 'for' ( (lv_var_1_0= ruleNamedVariableRule ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) ( (lv_body_4_0= ruleBodyRule ) ) )
            {
            // InternalGeneratorDSL.g:637:2: (otherlv_0= 'for' ( (lv_var_1_0= ruleNamedVariableRule ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) ( (lv_body_4_0= ruleBodyRule ) ) )
            // InternalGeneratorDSL.g:638:3: otherlv_0= 'for' ( (lv_var_1_0= ruleNamedVariableRule ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) ( (lv_body_4_0= ruleBodyRule ) )
            {
            otherlv_0=(Token)match(input,29,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getForStatementRuleAccess().getForKeyword_0());
              		
            }
            // InternalGeneratorDSL.g:642:3: ( (lv_var_1_0= ruleNamedVariableRule ) )
            // InternalGeneratorDSL.g:643:4: (lv_var_1_0= ruleNamedVariableRule )
            {
            // InternalGeneratorDSL.g:643:4: (lv_var_1_0= ruleNamedVariableRule )
            // InternalGeneratorDSL.g:644:5: lv_var_1_0= ruleNamedVariableRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForStatementRuleAccess().getVarNamedVariableRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_18);
            lv_var_1_0=ruleNamedVariableRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForStatementRuleRule());
              					}
              					set(
              						current,
              						"var",
              						lv_var_1_0,
              						"de.evoal.languages.model.generator.dsl.GeneratorDSL.NamedVariableRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,30,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getForStatementRuleAccess().getInKeyword_2());
              		
            }
            // InternalGeneratorDSL.g:665:3: ( (lv_range_3_0= ruleRangeRule ) )
            // InternalGeneratorDSL.g:666:4: (lv_range_3_0= ruleRangeRule )
            {
            // InternalGeneratorDSL.g:666:4: (lv_range_3_0= ruleRangeRule )
            // InternalGeneratorDSL.g:667:5: lv_range_3_0= ruleRangeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForStatementRuleAccess().getRangeRangeRuleParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_range_3_0=ruleRangeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForStatementRuleRule());
              					}
              					set(
              						current,
              						"range",
              						lv_range_3_0,
              						"de.evoal.languages.model.generator.dsl.GeneratorDSL.RangeRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGeneratorDSL.g:684:3: ( (lv_body_4_0= ruleBodyRule ) )
            // InternalGeneratorDSL.g:685:4: (lv_body_4_0= ruleBodyRule )
            {
            // InternalGeneratorDSL.g:685:4: (lv_body_4_0= ruleBodyRule )
            // InternalGeneratorDSL.g:686:5: lv_body_4_0= ruleBodyRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForStatementRuleAccess().getBodyBodyRuleParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_4_0=ruleBodyRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForStatementRuleRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_4_0,
              						"de.evoal.languages.model.generator.dsl.GeneratorDSL.BodyRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForStatementRule"


    // $ANTLR start "entryRuleNamedVariableRule"
    // InternalGeneratorDSL.g:707:1: entryRuleNamedVariableRule returns [EObject current=null] : iv_ruleNamedVariableRule= ruleNamedVariableRule EOF ;
    public final EObject entryRuleNamedVariableRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedVariableRule = null;


        try {
            // InternalGeneratorDSL.g:707:58: (iv_ruleNamedVariableRule= ruleNamedVariableRule EOF )
            // InternalGeneratorDSL.g:708:2: iv_ruleNamedVariableRule= ruleNamedVariableRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedVariableRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNamedVariableRule=ruleNamedVariableRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedVariableRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamedVariableRule"


    // $ANTLR start "ruleNamedVariableRule"
    // InternalGeneratorDSL.g:714:1: ruleNamedVariableRule returns [EObject current=null] : ( (lv_name_0_0= ruleStringOrId ) ) ;
    public final EObject ruleNamedVariableRule() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:720:2: ( ( (lv_name_0_0= ruleStringOrId ) ) )
            // InternalGeneratorDSL.g:721:2: ( (lv_name_0_0= ruleStringOrId ) )
            {
            // InternalGeneratorDSL.g:721:2: ( (lv_name_0_0= ruleStringOrId ) )
            // InternalGeneratorDSL.g:722:3: (lv_name_0_0= ruleStringOrId )
            {
            // InternalGeneratorDSL.g:722:3: (lv_name_0_0= ruleStringOrId )
            // InternalGeneratorDSL.g:723:4: lv_name_0_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getNamedVariableRuleAccess().getNameStringOrIdParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_name_0_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getNamedVariableRuleRule());
              				}
              				set(
              					current,
              					"name",
              					lv_name_0_0,
              					"de.evoal.languages.model.base.dsl.BaseLanguage.StringOrId");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamedVariableRule"


    // $ANTLR start "entryRuleRangeRule"
    // InternalGeneratorDSL.g:743:1: entryRuleRangeRule returns [EObject current=null] : iv_ruleRangeRule= ruleRangeRule EOF ;
    public final EObject entryRuleRangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeRule = null;


        try {
            // InternalGeneratorDSL.g:743:50: (iv_ruleRangeRule= ruleRangeRule EOF )
            // InternalGeneratorDSL.g:744:2: iv_ruleRangeRule= ruleRangeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRangeRule=ruleRangeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRangeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRangeRule"


    // $ANTLR start "ruleRangeRule"
    // InternalGeneratorDSL.g:750:1: ruleRangeRule returns [EObject current=null] : (this_CounterRangeRule_0= ruleCounterRangeRule | this_LiteralRangeRule_1= ruleLiteralRangeRule ) ;
    public final EObject ruleRangeRule() throws RecognitionException {
        EObject current = null;

        EObject this_CounterRangeRule_0 = null;

        EObject this_LiteralRangeRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:756:2: ( (this_CounterRangeRule_0= ruleCounterRangeRule | this_LiteralRangeRule_1= ruleLiteralRangeRule ) )
            // InternalGeneratorDSL.g:757:2: (this_CounterRangeRule_0= ruleCounterRangeRule | this_LiteralRangeRule_1= ruleLiteralRangeRule )
            {
            // InternalGeneratorDSL.g:757:2: (this_CounterRangeRule_0= ruleCounterRangeRule | this_LiteralRangeRule_1= ruleLiteralRangeRule )
            int alt13=2;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // InternalGeneratorDSL.g:758:3: this_CounterRangeRule_0= ruleCounterRangeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRangeRuleAccess().getCounterRangeRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CounterRangeRule_0=ruleCounterRangeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CounterRangeRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:770:3: this_LiteralRangeRule_1= ruleLiteralRangeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRangeRuleAccess().getLiteralRangeRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralRangeRule_1=ruleLiteralRangeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralRangeRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRangeRule"


    // $ANTLR start "entryRuleLiteralRangeRule"
    // InternalGeneratorDSL.g:785:1: entryRuleLiteralRangeRule returns [EObject current=null] : iv_ruleLiteralRangeRule= ruleLiteralRangeRule EOF ;
    public final EObject entryRuleLiteralRangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRangeRule = null;


        try {
            // InternalGeneratorDSL.g:785:57: (iv_ruleLiteralRangeRule= ruleLiteralRangeRule EOF )
            // InternalGeneratorDSL.g:786:2: iv_ruleLiteralRangeRule= ruleLiteralRangeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRangeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralRangeRule=ruleLiteralRangeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralRangeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralRangeRule"


    // $ANTLR start "ruleLiteralRangeRule"
    // InternalGeneratorDSL.g:792:1: ruleLiteralRangeRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_elements_1_0= ruleReadExpressionRule ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleReadExpressionRule ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleLiteralRangeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_1_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:798:2: ( (otherlv_0= '[' ( (lv_elements_1_0= ruleReadExpressionRule ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleReadExpressionRule ) ) )* otherlv_4= ']' ) )
            // InternalGeneratorDSL.g:799:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleReadExpressionRule ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleReadExpressionRule ) ) )* otherlv_4= ']' )
            {
            // InternalGeneratorDSL.g:799:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleReadExpressionRule ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleReadExpressionRule ) ) )* otherlv_4= ']' )
            // InternalGeneratorDSL.g:800:3: otherlv_0= '[' ( (lv_elements_1_0= ruleReadExpressionRule ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleReadExpressionRule ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLiteralRangeRuleAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalGeneratorDSL.g:804:3: ( (lv_elements_1_0= ruleReadExpressionRule ) )
            // InternalGeneratorDSL.g:805:4: (lv_elements_1_0= ruleReadExpressionRule )
            {
            // InternalGeneratorDSL.g:805:4: (lv_elements_1_0= ruleReadExpressionRule )
            // InternalGeneratorDSL.g:806:5: lv_elements_1_0= ruleReadExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLiteralRangeRuleAccess().getElementsReadExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_elements_1_0=ruleReadExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLiteralRangeRuleRule());
              					}
              					add(
              						current,
              						"elements",
              						lv_elements_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.ReadExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGeneratorDSL.g:823:3: (otherlv_2= ',' ( (lv_elements_3_0= ruleReadExpressionRule ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==24) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalGeneratorDSL.g:824:4: otherlv_2= ',' ( (lv_elements_3_0= ruleReadExpressionRule ) )
            	    {
            	    otherlv_2=(Token)match(input,24,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLiteralRangeRuleAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalGeneratorDSL.g:828:4: ( (lv_elements_3_0= ruleReadExpressionRule ) )
            	    // InternalGeneratorDSL.g:829:5: (lv_elements_3_0= ruleReadExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:829:5: (lv_elements_3_0= ruleReadExpressionRule )
            	    // InternalGeneratorDSL.g:830:6: lv_elements_3_0= ruleReadExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLiteralRangeRuleAccess().getElementsReadExpressionRuleParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_elements_3_0=ruleReadExpressionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLiteralRangeRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"elements",
            	      							lv_elements_3_0,
            	      							"de.evoal.languages.model.base.dsl.BaseLanguage.ReadExpressionRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_4=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getLiteralRangeRuleAccess().getRightSquareBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralRangeRule"


    // $ANTLR start "entryRuleCounterRangeRule"
    // InternalGeneratorDSL.g:856:1: entryRuleCounterRangeRule returns [EObject current=null] : iv_ruleCounterRangeRule= ruleCounterRangeRule EOF ;
    public final EObject entryRuleCounterRangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCounterRangeRule = null;


        try {
            // InternalGeneratorDSL.g:856:57: (iv_ruleCounterRangeRule= ruleCounterRangeRule EOF )
            // InternalGeneratorDSL.g:857:2: iv_ruleCounterRangeRule= ruleCounterRangeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCounterRangeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCounterRangeRule=ruleCounterRangeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCounterRangeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCounterRangeRule"


    // $ANTLR start "ruleCounterRangeRule"
    // InternalGeneratorDSL.g:863:1: ruleCounterRangeRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_start_1_0= ruleIntegerLiteralRule ) ) otherlv_2= 'to' ( (lv_end_3_0= ruleIntegerLiteralRule ) ) otherlv_4= 'increment' otherlv_5= 'by' ( (lv_increment_6_0= ruleIntegerLiteralRule ) ) otherlv_7= ']' ) ;
    public final EObject ruleCounterRangeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_start_1_0 = null;

        EObject lv_end_3_0 = null;

        EObject lv_increment_6_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:869:2: ( (otherlv_0= '[' ( (lv_start_1_0= ruleIntegerLiteralRule ) ) otherlv_2= 'to' ( (lv_end_3_0= ruleIntegerLiteralRule ) ) otherlv_4= 'increment' otherlv_5= 'by' ( (lv_increment_6_0= ruleIntegerLiteralRule ) ) otherlv_7= ']' ) )
            // InternalGeneratorDSL.g:870:2: (otherlv_0= '[' ( (lv_start_1_0= ruleIntegerLiteralRule ) ) otherlv_2= 'to' ( (lv_end_3_0= ruleIntegerLiteralRule ) ) otherlv_4= 'increment' otherlv_5= 'by' ( (lv_increment_6_0= ruleIntegerLiteralRule ) ) otherlv_7= ']' )
            {
            // InternalGeneratorDSL.g:870:2: (otherlv_0= '[' ( (lv_start_1_0= ruleIntegerLiteralRule ) ) otherlv_2= 'to' ( (lv_end_3_0= ruleIntegerLiteralRule ) ) otherlv_4= 'increment' otherlv_5= 'by' ( (lv_increment_6_0= ruleIntegerLiteralRule ) ) otherlv_7= ']' )
            // InternalGeneratorDSL.g:871:3: otherlv_0= '[' ( (lv_start_1_0= ruleIntegerLiteralRule ) ) otherlv_2= 'to' ( (lv_end_3_0= ruleIntegerLiteralRule ) ) otherlv_4= 'increment' otherlv_5= 'by' ( (lv_increment_6_0= ruleIntegerLiteralRule ) ) otherlv_7= ']'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCounterRangeRuleAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalGeneratorDSL.g:875:3: ( (lv_start_1_0= ruleIntegerLiteralRule ) )
            // InternalGeneratorDSL.g:876:4: (lv_start_1_0= ruleIntegerLiteralRule )
            {
            // InternalGeneratorDSL.g:876:4: (lv_start_1_0= ruleIntegerLiteralRule )
            // InternalGeneratorDSL.g:877:5: lv_start_1_0= ruleIntegerLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCounterRangeRuleAccess().getStartIntegerLiteralRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_start_1_0=ruleIntegerLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCounterRangeRuleRule());
              					}
              					set(
              						current,
              						"start",
              						lv_start_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.IntegerLiteralRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,31,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCounterRangeRuleAccess().getToKeyword_2());
              		
            }
            // InternalGeneratorDSL.g:898:3: ( (lv_end_3_0= ruleIntegerLiteralRule ) )
            // InternalGeneratorDSL.g:899:4: (lv_end_3_0= ruleIntegerLiteralRule )
            {
            // InternalGeneratorDSL.g:899:4: (lv_end_3_0= ruleIntegerLiteralRule )
            // InternalGeneratorDSL.g:900:5: lv_end_3_0= ruleIntegerLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCounterRangeRuleAccess().getEndIntegerLiteralRuleParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_end_3_0=ruleIntegerLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCounterRangeRuleRule());
              					}
              					set(
              						current,
              						"end",
              						lv_end_3_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.IntegerLiteralRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,32,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getCounterRangeRuleAccess().getIncrementKeyword_4());
              		
            }
            otherlv_5=(Token)match(input,33,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCounterRangeRuleAccess().getByKeyword_5());
              		
            }
            // InternalGeneratorDSL.g:925:3: ( (lv_increment_6_0= ruleIntegerLiteralRule ) )
            // InternalGeneratorDSL.g:926:4: (lv_increment_6_0= ruleIntegerLiteralRule )
            {
            // InternalGeneratorDSL.g:926:4: (lv_increment_6_0= ruleIntegerLiteralRule )
            // InternalGeneratorDSL.g:927:5: lv_increment_6_0= ruleIntegerLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCounterRangeRuleAccess().getIncrementIntegerLiteralRuleParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_24);
            lv_increment_6_0=ruleIntegerLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCounterRangeRuleRule());
              					}
              					set(
              						current,
              						"increment",
              						lv_increment_6_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.IntegerLiteralRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_7=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getCounterRangeRuleAccess().getRightSquareBracketKeyword_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCounterRangeRule"


    // $ANTLR start "entryRuleApplyStatementRule"
    // InternalGeneratorDSL.g:952:1: entryRuleApplyStatementRule returns [EObject current=null] : iv_ruleApplyStatementRule= ruleApplyStatementRule EOF ;
    public final EObject entryRuleApplyStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApplyStatementRule = null;


        try {
            // InternalGeneratorDSL.g:952:59: (iv_ruleApplyStatementRule= ruleApplyStatementRule EOF )
            // InternalGeneratorDSL.g:953:2: iv_ruleApplyStatementRule= ruleApplyStatementRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getApplyStatementRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleApplyStatementRule=ruleApplyStatementRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleApplyStatementRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleApplyStatementRule"


    // $ANTLR start "ruleApplyStatementRule"
    // InternalGeneratorDSL.g:959:1: ruleApplyStatementRule returns [EObject current=null] : (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= ruleLiteralRule ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= ruleVariableReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= ruleVariableReferenceRule ) ) )* otherlv_11= ']' otherlv_12= ';' ) ;
    public final EObject ruleApplyStatementRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_file_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_count_3_0 = null;

        EObject lv_pipelines_8_0 = null;

        EObject lv_pipelines_10_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:965:2: ( (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= ruleLiteralRule ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= ruleVariableReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= ruleVariableReferenceRule ) ) )* otherlv_11= ']' otherlv_12= ';' ) )
            // InternalGeneratorDSL.g:966:2: (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= ruleLiteralRule ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= ruleVariableReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= ruleVariableReferenceRule ) ) )* otherlv_11= ']' otherlv_12= ';' )
            {
            // InternalGeneratorDSL.g:966:2: (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= ruleLiteralRule ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= ruleVariableReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= ruleVariableReferenceRule ) ) )* otherlv_11= ']' otherlv_12= ';' )
            // InternalGeneratorDSL.g:967:3: otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= ruleLiteralRule ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= ruleVariableReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= ruleVariableReferenceRule ) ) )* otherlv_11= ']' otherlv_12= ';'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getApplyStatementRuleAccess().getWriteKeyword_0());
              		
            }
            // InternalGeneratorDSL.g:971:3: ( (lv_file_1_0= RULE_STRING ) )
            // InternalGeneratorDSL.g:972:4: (lv_file_1_0= RULE_STRING )
            {
            // InternalGeneratorDSL.g:972:4: (lv_file_1_0= RULE_STRING )
            // InternalGeneratorDSL.g:973:5: lv_file_1_0= RULE_STRING
            {
            lv_file_1_0=(Token)match(input,RULE_STRING,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_file_1_0, grammarAccess.getApplyStatementRuleAccess().getFileSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getApplyStatementRuleRule());
              					}
              					setWithLastConsumed(
              						current,
              						"file",
              						lv_file_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getApplyStatementRuleAccess().getWithKeyword_2());
              		
            }
            // InternalGeneratorDSL.g:993:3: ( (lv_count_3_0= ruleLiteralRule ) )
            // InternalGeneratorDSL.g:994:4: (lv_count_3_0= ruleLiteralRule )
            {
            // InternalGeneratorDSL.g:994:4: (lv_count_3_0= ruleLiteralRule )
            // InternalGeneratorDSL.g:995:5: lv_count_3_0= ruleLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getApplyStatementRuleAccess().getCountLiteralRuleParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_28);
            lv_count_3_0=ruleLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getApplyStatementRuleRule());
              					}
              					set(
              						current,
              						"count",
              						lv_count_3_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.LiteralRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,36,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getApplyStatementRuleAccess().getSamplesKeyword_4());
              		
            }
            otherlv_5=(Token)match(input,37,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getApplyStatementRuleAccess().getFromKeyword_5());
              		
            }
            otherlv_6=(Token)match(input,38,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getApplyStatementRuleAccess().getExecutingKeyword_6());
              		
            }
            otherlv_7=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getApplyStatementRuleAccess().getLeftSquareBracketKeyword_7());
              		
            }
            // InternalGeneratorDSL.g:1028:3: ( (lv_pipelines_8_0= ruleVariableReferenceRule ) )
            // InternalGeneratorDSL.g:1029:4: (lv_pipelines_8_0= ruleVariableReferenceRule )
            {
            // InternalGeneratorDSL.g:1029:4: (lv_pipelines_8_0= ruleVariableReferenceRule )
            // InternalGeneratorDSL.g:1030:5: lv_pipelines_8_0= ruleVariableReferenceRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getApplyStatementRuleAccess().getPipelinesVariableReferenceRuleParserRuleCall_8_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_pipelines_8_0=ruleVariableReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getApplyStatementRuleRule());
              					}
              					add(
              						current,
              						"pipelines",
              						lv_pipelines_8_0,
              						"de.evoal.languages.model.generator.dsl.GeneratorDSL.VariableReferenceRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGeneratorDSL.g:1047:3: (otherlv_9= ',' ( (lv_pipelines_10_0= ruleVariableReferenceRule ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==24) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1048:4: otherlv_9= ',' ( (lv_pipelines_10_0= ruleVariableReferenceRule ) )
            	    {
            	    otherlv_9=(Token)match(input,24,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_9, grammarAccess.getApplyStatementRuleAccess().getCommaKeyword_9_0());
            	      			
            	    }
            	    // InternalGeneratorDSL.g:1052:4: ( (lv_pipelines_10_0= ruleVariableReferenceRule ) )
            	    // InternalGeneratorDSL.g:1053:5: (lv_pipelines_10_0= ruleVariableReferenceRule )
            	    {
            	    // InternalGeneratorDSL.g:1053:5: (lv_pipelines_10_0= ruleVariableReferenceRule )
            	    // InternalGeneratorDSL.g:1054:6: lv_pipelines_10_0= ruleVariableReferenceRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getApplyStatementRuleAccess().getPipelinesVariableReferenceRuleParserRuleCall_9_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_pipelines_10_0=ruleVariableReferenceRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getApplyStatementRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"pipelines",
            	      							lv_pipelines_10_0,
            	      							"de.evoal.languages.model.generator.dsl.GeneratorDSL.VariableReferenceRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_11=(Token)match(input,20,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getApplyStatementRuleAccess().getRightSquareBracketKeyword_10());
              		
            }
            otherlv_12=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_12, grammarAccess.getApplyStatementRuleAccess().getSemicolonKeyword_11());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleApplyStatementRule"


    // $ANTLR start "entryRuleReferenceRule"
    // InternalGeneratorDSL.g:1084:1: entryRuleReferenceRule returns [EObject current=null] : iv_ruleReferenceRule= ruleReferenceRule EOF ;
    public final EObject entryRuleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:1084:54: (iv_ruleReferenceRule= ruleReferenceRule EOF )
            // InternalGeneratorDSL.g:1085:2: iv_ruleReferenceRule= ruleReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReferenceRule=ruleReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceRule"


    // $ANTLR start "ruleReferenceRule"
    // InternalGeneratorDSL.g:1091:1: ruleReferenceRule returns [EObject current=null] : (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_TypeDefinitionReferenceRule_1= ruleTypeDefinitionReferenceRule | this_VariableReferenceRule_2= ruleVariableReferenceRule ) ;
    public final EObject ruleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_ValuelDefinitionReferenceRule_0 = null;

        EObject this_TypeDefinitionReferenceRule_1 = null;

        EObject this_VariableReferenceRule_2 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1097:2: ( (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_TypeDefinitionReferenceRule_1= ruleTypeDefinitionReferenceRule | this_VariableReferenceRule_2= ruleVariableReferenceRule ) )
            // InternalGeneratorDSL.g:1098:2: (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_TypeDefinitionReferenceRule_1= ruleTypeDefinitionReferenceRule | this_VariableReferenceRule_2= ruleVariableReferenceRule )
            {
            // InternalGeneratorDSL.g:1098:2: (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_TypeDefinitionReferenceRule_1= ruleTypeDefinitionReferenceRule | this_VariableReferenceRule_2= ruleVariableReferenceRule )
            int alt16=3;
            switch ( input.LA(1) ) {
            case RULE_QUOTED_ID:
                {
                int LA16_1 = input.LA(2);

                if ( (synpred17_InternalGeneratorDSL()) ) {
                    alt16=1;
                }
                else if ( (true) ) {
                    alt16=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA16_2 = input.LA(2);

                if ( (synpred17_InternalGeneratorDSL()) ) {
                    alt16=1;
                }
                else if ( (true) ) {
                    alt16=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 2, input);

                    throw nvae;
                }
                }
                break;
            case 46:
            case 47:
                {
                alt16=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalGeneratorDSL.g:1099:3: this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReferenceRuleAccess().getValuelDefinitionReferenceRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ValuelDefinitionReferenceRule_0=ruleValuelDefinitionReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ValuelDefinitionReferenceRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:1111:3: this_TypeDefinitionReferenceRule_1= ruleTypeDefinitionReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReferenceRuleAccess().getTypeDefinitionReferenceRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeDefinitionReferenceRule_1=ruleTypeDefinitionReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeDefinitionReferenceRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:1123:3: this_VariableReferenceRule_2= ruleVariableReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReferenceRuleAccess().getVariableReferenceRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VariableReferenceRule_2=ruleVariableReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VariableReferenceRule_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceRule"


    // $ANTLR start "entryRuleVariableReferenceRule"
    // InternalGeneratorDSL.g:1138:1: entryRuleVariableReferenceRule returns [EObject current=null] : iv_ruleVariableReferenceRule= ruleVariableReferenceRule EOF ;
    public final EObject entryRuleVariableReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:1138:62: (iv_ruleVariableReferenceRule= ruleVariableReferenceRule EOF )
            // InternalGeneratorDSL.g:1139:2: iv_ruleVariableReferenceRule= ruleVariableReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableReferenceRule=ruleVariableReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableReferenceRule"


    // $ANTLR start "ruleVariableReferenceRule"
    // InternalGeneratorDSL.g:1145:1: ruleVariableReferenceRule returns [EObject current=null] : ( ( ruleStringOrId ) ) ;
    public final EObject ruleVariableReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:1151:2: ( ( ( ruleStringOrId ) ) )
            // InternalGeneratorDSL.g:1152:2: ( ( ruleStringOrId ) )
            {
            // InternalGeneratorDSL.g:1152:2: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:1153:3: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:1153:3: ( ruleStringOrId )
            // InternalGeneratorDSL.g:1154:4: ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getVariableReferenceRuleRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getVariableReferenceRuleAccess().getVariableNamedVariableCrossReference_0());
              			
            }
            pushFollow(FOLLOW_2);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableReferenceRule"


    // $ANTLR start "entryRuleCallBuiltInFunctionRule"
    // InternalGeneratorDSL.g:1174:1: entryRuleCallBuiltInFunctionRule returns [EObject current=null] : iv_ruleCallBuiltInFunctionRule= ruleCallBuiltInFunctionRule EOF ;
    public final EObject entryRuleCallBuiltInFunctionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallBuiltInFunctionRule = null;


        try {
            // InternalGeneratorDSL.g:1174:64: (iv_ruleCallBuiltInFunctionRule= ruleCallBuiltInFunctionRule EOF )
            // InternalGeneratorDSL.g:1175:2: iv_ruleCallBuiltInFunctionRule= ruleCallBuiltInFunctionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallBuiltInFunctionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCallBuiltInFunctionRule=ruleCallBuiltInFunctionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCallBuiltInFunctionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallBuiltInFunctionRule"


    // $ANTLR start "ruleCallBuiltInFunctionRule"
    // InternalGeneratorDSL.g:1181:1: ruleCallBuiltInFunctionRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' otherlv_6= ';' ) ;
    public final EObject ruleCallBuiltInFunctionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_parameters_4_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1187:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' otherlv_6= ';' ) )
            // InternalGeneratorDSL.g:1188:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalGeneratorDSL.g:1188:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' otherlv_6= ';' )
            // InternalGeneratorDSL.g:1189:3: ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' otherlv_6= ';'
            {
            // InternalGeneratorDSL.g:1189:3: ( ( ruleQualifiedName ) )
            // InternalGeneratorDSL.g:1190:4: ( ruleQualifiedName )
            {
            // InternalGeneratorDSL.g:1190:4: ( ruleQualifiedName )
            // InternalGeneratorDSL.g:1191:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCallBuiltInFunctionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCallBuiltInFunctionRuleAccess().getDefinitionFunctionDefinitionCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_31);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,39,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallBuiltInFunctionRuleAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalGeneratorDSL.g:1212:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_STRING && LA18_0<=RULE_ID)||LA18_0==19||LA18_0==39||LA18_0==44||(LA18_0>=46 && LA18_0<=47)||(LA18_0>=49 && LA18_0<=50)||(LA18_0>=71 && LA18_0<=72)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalGeneratorDSL.g:1213:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalGeneratorDSL.g:1213:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalGeneratorDSL.g:1214:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalGeneratorDSL.g:1214:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalGeneratorDSL.g:1215:6: lv_parameters_2_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallBuiltInFunctionRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_33);
                    lv_parameters_2_0=ruleExpressionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCallBuiltInFunctionRuleRule());
                      						}
                      						add(
                      							current,
                      							"parameters",
                      							lv_parameters_2_0,
                      							"de.evoal.languages.model.base.dsl.BaseLanguage.ExpressionRule");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalGeneratorDSL.g:1232:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==24) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalGeneratorDSL.g:1233:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,24,FOLLOW_34); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getCallBuiltInFunctionRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalGeneratorDSL.g:1237:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalGeneratorDSL.g:1238:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalGeneratorDSL.g:1238:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalGeneratorDSL.g:1239:7: lv_parameters_4_0= ruleExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCallBuiltInFunctionRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_33);
                    	    lv_parameters_4_0=ruleExpressionRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getCallBuiltInFunctionRuleRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parameters",
                    	      								lv_parameters_4_0,
                    	      								"de.evoal.languages.model.base.dsl.BaseLanguage.ExpressionRule");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,40,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCallBuiltInFunctionRuleAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_6=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getCallBuiltInFunctionRuleAccess().getSemicolonKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallBuiltInFunctionRule"


    // $ANTLR start "entryRuleExpressionRule"
    // InternalGeneratorDSL.g:1270:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1270:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalGeneratorDSL.g:1271:2: iv_ruleExpressionRule= ruleExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionRule=ruleExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionRule"


    // $ANTLR start "ruleExpressionRule"
    // InternalGeneratorDSL.g:1277:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1283:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalGeneratorDSL.g:1284:2: this_OrExpressionRule_0= ruleOrExpressionRule
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionRuleAccess().getOrExpressionRuleParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_OrExpressionRule_0=ruleOrExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_OrExpressionRule_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionRule"


    // $ANTLR start "entryRuleOrExpressionRule"
    // InternalGeneratorDSL.g:1298:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1298:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalGeneratorDSL.g:1299:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOrExpressionRule=ruleOrExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpressionRule"


    // $ANTLR start "ruleOrExpressionRule"
    // InternalGeneratorDSL.g:1305:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1311:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1312:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1312:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1313:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1313:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalGeneratorDSL.g:1314:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalGeneratorDSL.g:1314:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalGeneratorDSL.g:1315:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_35);
            lv_subExpressions_0_0=ruleXorExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getOrExpressionRuleRule());
              					}
              					add(
              						current,
              						"subExpressions",
              						lv_subExpressions_0_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.XorExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGeneratorDSL.g:1332:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==41) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1333:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,41,FOLLOW_34); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	      			
            	    }
            	    // InternalGeneratorDSL.g:1337:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalGeneratorDSL.g:1338:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1338:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalGeneratorDSL.g:1339:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_subExpressions_2_0=ruleXorExpressionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getOrExpressionRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"subExpressions",
            	      							lv_subExpressions_2_0,
            	      							"de.evoal.languages.model.base.dsl.BaseLanguage.XorExpressionRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpressionRule"


    // $ANTLR start "entryRuleXorExpressionRule"
    // InternalGeneratorDSL.g:1361:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1361:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalGeneratorDSL.g:1362:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXorExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXorExpressionRule=ruleXorExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXorExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXorExpressionRule"


    // $ANTLR start "ruleXorExpressionRule"
    // InternalGeneratorDSL.g:1368:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1374:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1375:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1375:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1376:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1376:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalGeneratorDSL.g:1377:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalGeneratorDSL.g:1377:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalGeneratorDSL.g:1378:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_36);
            lv_subExpressions_0_0=ruleAndExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXorExpressionRuleRule());
              					}
              					add(
              						current,
              						"subExpressions",
              						lv_subExpressions_0_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.AndExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGeneratorDSL.g:1395:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==42) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1396:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,42,FOLLOW_34); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	      			
            	    }
            	    // InternalGeneratorDSL.g:1400:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalGeneratorDSL.g:1401:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1401:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalGeneratorDSL.g:1402:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_subExpressions_2_0=ruleAndExpressionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXorExpressionRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"subExpressions",
            	      							lv_subExpressions_2_0,
            	      							"de.evoal.languages.model.base.dsl.BaseLanguage.AndExpressionRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXorExpressionRule"


    // $ANTLR start "entryRuleAndExpressionRule"
    // InternalGeneratorDSL.g:1424:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1424:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalGeneratorDSL.g:1425:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAndExpressionRule=ruleAndExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpressionRule"


    // $ANTLR start "ruleAndExpressionRule"
    // InternalGeneratorDSL.g:1431:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1437:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1438:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1438:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1439:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1439:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalGeneratorDSL.g:1440:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalGeneratorDSL.g:1440:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalGeneratorDSL.g:1441:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_37);
            lv_subExpressions_0_0=ruleNotExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAndExpressionRuleRule());
              					}
              					add(
              						current,
              						"subExpressions",
              						lv_subExpressions_0_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.NotExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGeneratorDSL.g:1458:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==43) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1459:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,43,FOLLOW_34); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	      			
            	    }
            	    // InternalGeneratorDSL.g:1463:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalGeneratorDSL.g:1464:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1464:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalGeneratorDSL.g:1465:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_37);
            	    lv_subExpressions_2_0=ruleNotExpressionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAndExpressionRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"subExpressions",
            	      							lv_subExpressions_2_0,
            	      							"de.evoal.languages.model.base.dsl.BaseLanguage.NotExpressionRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpressionRule"


    // $ANTLR start "entryRuleNotExpressionRule"
    // InternalGeneratorDSL.g:1487:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1487:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalGeneratorDSL.g:1488:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNotExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNotExpressionRule=ruleNotExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNotExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotExpressionRule"


    // $ANTLR start "ruleNotExpressionRule"
    // InternalGeneratorDSL.g:1494:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1500:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalGeneratorDSL.g:1501:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalGeneratorDSL.g:1501:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalGeneratorDSL.g:1502:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalGeneratorDSL.g:1502:3: ( (lv_negated_0_0= '!' ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==44) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalGeneratorDSL.g:1503:4: (lv_negated_0_0= '!' )
                    {
                    // InternalGeneratorDSL.g:1503:4: (lv_negated_0_0= '!' )
                    // InternalGeneratorDSL.g:1504:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,44,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_negated_0_0, grammarAccess.getNotExpressionRuleAccess().getNegatedExclamationMarkKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getNotExpressionRuleRule());
                      					}
                      					setWithLastConsumed(current, "negated", lv_negated_0_0 != null, "!");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalGeneratorDSL.g:1516:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalGeneratorDSL.g:1517:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalGeneratorDSL.g:1517:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalGeneratorDSL.g:1518:5: lv_operand_1_0= ruleComparisonExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNotExpressionRuleAccess().getOperandComparisonExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_1_0=ruleComparisonExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getNotExpressionRuleRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.ComparisonExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotExpressionRule"


    // $ANTLR start "entryRuleComparisonExpressionRule"
    // InternalGeneratorDSL.g:1539:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1539:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalGeneratorDSL.g:1540:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComparisonExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComparisonExpressionRule=ruleComparisonExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComparisonExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparisonExpressionRule"


    // $ANTLR start "ruleComparisonExpressionRule"
    // InternalGeneratorDSL.g:1546:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1552:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalGeneratorDSL.g:1553:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalGeneratorDSL.g:1553:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalGeneratorDSL.g:1554:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalGeneratorDSL.g:1554:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalGeneratorDSL.g:1555:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalGeneratorDSL.g:1555:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalGeneratorDSL.g:1556:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_38);
            lv_leftOperand_0_0=ruleAddOrSubtractExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getComparisonExpressionRuleRule());
              					}
              					set(
              						current,
              						"leftOperand",
              						lv_leftOperand_0_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.AddOrSubtractExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGeneratorDSL.g:1573:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=65 && LA23_0<=70)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1574:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1574:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalGeneratorDSL.g:1575:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_comparison_1_0=rulePartialComparisonExpressionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getComparisonExpressionRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"comparison",
            	      						lv_comparison_1_0,
            	      						"de.evoal.languages.model.base.dsl.BaseLanguage.PartialComparisonExpressionRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparisonExpressionRule"


    // $ANTLR start "entryRulePartialComparisonExpressionRule"
    // InternalGeneratorDSL.g:1596:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1596:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalGeneratorDSL.g:1597:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePartialComparisonExpressionRule=rulePartialComparisonExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartialComparisonExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePartialComparisonExpressionRule"


    // $ANTLR start "rulePartialComparisonExpressionRule"
    // InternalGeneratorDSL.g:1603:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1609:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalGeneratorDSL.g:1610:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalGeneratorDSL.g:1610:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalGeneratorDSL.g:1611:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalGeneratorDSL.g:1611:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalGeneratorDSL.g:1612:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalGeneratorDSL.g:1612:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalGeneratorDSL.g:1613:5: lv_operator_0_0= ruleComparisonOperatorRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_34);
            lv_operator_0_0=ruleComparisonOperatorRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPartialComparisonExpressionRuleRule());
              					}
              					set(
              						current,
              						"operator",
              						lv_operator_0_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.ComparisonOperatorRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGeneratorDSL.g:1630:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalGeneratorDSL.g:1631:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalGeneratorDSL.g:1631:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalGeneratorDSL.g:1632:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getSubExpressionAddOrSubtractExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_subExpression_1_0=ruleAddOrSubtractExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPartialComparisonExpressionRuleRule());
              					}
              					set(
              						current,
              						"subExpression",
              						lv_subExpression_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.AddOrSubtractExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePartialComparisonExpressionRule"


    // $ANTLR start "entryRuleAddOrSubtractExpressionRule"
    // InternalGeneratorDSL.g:1653:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1653:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalGeneratorDSL.g:1654:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAddOrSubtractExpressionRule=ruleAddOrSubtractExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddOrSubtractExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddOrSubtractExpressionRule"


    // $ANTLR start "ruleAddOrSubtractExpressionRule"
    // InternalGeneratorDSL.g:1660:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1666:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1667:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1667:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1668:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1668:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalGeneratorDSL.g:1669:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalGeneratorDSL.g:1669:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalGeneratorDSL.g:1670:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_39);
            lv_leftOperand_0_0=ruleMultiplyDivideModuloExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAddOrSubtractExpressionRuleRule());
              					}
              					set(
              						current,
              						"leftOperand",
              						lv_leftOperand_0_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.MultiplyDivideModuloExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGeneratorDSL.g:1687:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=71 && LA24_0<=72)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1688:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalGeneratorDSL.g:1688:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalGeneratorDSL.g:1689:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalGeneratorDSL.g:1689:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalGeneratorDSL.g:1690:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_operators_1_0=ruleAddOrSubtractOperatorRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAddOrSubtractExpressionRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"operators",
            	      							lv_operators_1_0,
            	      							"de.evoal.languages.model.base.dsl.BaseLanguage.AddOrSubtractOperatorRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalGeneratorDSL.g:1707:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalGeneratorDSL.g:1708:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1708:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalGeneratorDSL.g:1709:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_operands_2_0=ruleMultiplyDivideModuloExpressionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAddOrSubtractExpressionRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"operands",
            	      							lv_operands_2_0,
            	      							"de.evoal.languages.model.base.dsl.BaseLanguage.MultiplyDivideModuloExpressionRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddOrSubtractExpressionRule"


    // $ANTLR start "entryRuleMultiplyDivideModuloExpressionRule"
    // InternalGeneratorDSL.g:1731:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1731:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalGeneratorDSL.g:1732:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplyDivideModuloExpressionRule=ruleMultiplyDivideModuloExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplyDivideModuloExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplyDivideModuloExpressionRule"


    // $ANTLR start "ruleMultiplyDivideModuloExpressionRule"
    // InternalGeneratorDSL.g:1738:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1744:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalGeneratorDSL.g:1745:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalGeneratorDSL.g:1745:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalGeneratorDSL.g:1746:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalGeneratorDSL.g:1746:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalGeneratorDSL.g:1747:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalGeneratorDSL.g:1747:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalGeneratorDSL.g:1748:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_40);
            lv_leftOperand_0_0=rulePowerOfExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMultiplyDivideModuloExpressionRuleRule());
              					}
              					set(
              						current,
              						"leftOperand",
              						lv_leftOperand_0_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.PowerOfExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGeneratorDSL.g:1765:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=73 && LA25_0<=75)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1766:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalGeneratorDSL.g:1766:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalGeneratorDSL.g:1767:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalGeneratorDSL.g:1767:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalGeneratorDSL.g:1768:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_operators_1_0=ruleMultiplyDivideModuloOperatorRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplyDivideModuloExpressionRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"operators",
            	      							lv_operators_1_0,
            	      							"de.evoal.languages.model.base.dsl.BaseLanguage.MultiplyDivideModuloOperatorRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalGeneratorDSL.g:1785:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalGeneratorDSL.g:1786:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalGeneratorDSL.g:1786:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalGeneratorDSL.g:1787:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_40);
            	    lv_operands_2_0=rulePowerOfExpressionRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplyDivideModuloExpressionRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"operands",
            	      							lv_operands_2_0,
            	      							"de.evoal.languages.model.base.dsl.BaseLanguage.PowerOfExpressionRule");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplyDivideModuloExpressionRule"


    // $ANTLR start "entryRulePowerOfExpressionRule"
    // InternalGeneratorDSL.g:1809:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1809:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalGeneratorDSL.g:1810:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPowerOfExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePowerOfExpressionRule=rulePowerOfExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePowerOfExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerOfExpressionRule"


    // $ANTLR start "rulePowerOfExpressionRule"
    // InternalGeneratorDSL.g:1816:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1822:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalGeneratorDSL.g:1823:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalGeneratorDSL.g:1823:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalGeneratorDSL.g:1824:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalGeneratorDSL.g:1824:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalGeneratorDSL.g:1825:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalGeneratorDSL.g:1825:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalGeneratorDSL.g:1826:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_41);
            lv_leftOperand_0_0=ruleUnaryAddOrSubtractExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPowerOfExpressionRuleRule());
              					}
              					set(
              						current,
              						"leftOperand",
              						lv_leftOperand_0_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.UnaryAddOrSubtractExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGeneratorDSL.g:1843:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==45) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalGeneratorDSL.g:1844:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,45,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                      			
                    }
                    // InternalGeneratorDSL.g:1848:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalGeneratorDSL.g:1849:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalGeneratorDSL.g:1849:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalGeneratorDSL.g:1850:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getRightOperandPowerOfExpressionRuleParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_rightOperand_2_0=rulePowerOfExpressionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPowerOfExpressionRuleRule());
                      						}
                      						set(
                      							current,
                      							"rightOperand",
                      							lv_rightOperand_2_0,
                      							"de.evoal.languages.model.base.dsl.BaseLanguage.PowerOfExpressionRule");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerOfExpressionRule"


    // $ANTLR start "entryRuleUnaryAddOrSubtractExpressionRule"
    // InternalGeneratorDSL.g:1872:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1872:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalGeneratorDSL.g:1873:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryAddOrSubtractExpressionRule=ruleUnaryAddOrSubtractExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryAddOrSubtractExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryAddOrSubtractExpressionRule"


    // $ANTLR start "ruleUnaryAddOrSubtractExpressionRule"
    // InternalGeneratorDSL.g:1879:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1885:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) ) )
            // InternalGeneratorDSL.g:1886:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) )
            {
            // InternalGeneratorDSL.g:1886:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) )
            // InternalGeneratorDSL.g:1887:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) )
            {
            // InternalGeneratorDSL.g:1887:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=71 && LA27_0<=72)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalGeneratorDSL.g:1888:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalGeneratorDSL.g:1888:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalGeneratorDSL.g:1889:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_42);
            	    lv_operators_0_0=ruleAddOrSubtractOperatorRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getUnaryAddOrSubtractExpressionRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"operators",
            	      						lv_operators_0_0,
            	      						"de.evoal.languages.model.base.dsl.BaseLanguage.AddOrSubtractOperatorRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            // InternalGeneratorDSL.g:1906:3: ( (lv_subExpression_1_0= ruleReadExpressionRule ) )
            // InternalGeneratorDSL.g:1907:4: (lv_subExpression_1_0= ruleReadExpressionRule )
            {
            // InternalGeneratorDSL.g:1907:4: (lv_subExpression_1_0= ruleReadExpressionRule )
            // InternalGeneratorDSL.g:1908:5: lv_subExpression_1_0= ruleReadExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getSubExpressionReadExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_subExpression_1_0=ruleReadExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUnaryAddOrSubtractExpressionRuleRule());
              					}
              					set(
              						current,
              						"subExpression",
              						lv_subExpression_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.ReadExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryAddOrSubtractExpressionRule"


    // $ANTLR start "entryRuleReadExpressionRule"
    // InternalGeneratorDSL.g:1929:1: entryRuleReadExpressionRule returns [EObject current=null] : iv_ruleReadExpressionRule= ruleReadExpressionRule EOF ;
    public final EObject entryRuleReadExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReadExpressionRule = null;


        try {
            // InternalGeneratorDSL.g:1929:59: (iv_ruleReadExpressionRule= ruleReadExpressionRule EOF )
            // InternalGeneratorDSL.g:1930:2: iv_ruleReadExpressionRule= ruleReadExpressionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReadExpressionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReadExpressionRule=ruleReadExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReadExpressionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReadExpressionRule"


    // $ANTLR start "ruleReadExpressionRule"
    // InternalGeneratorDSL.g:1936:1: ruleReadExpressionRule returns [EObject current=null] : (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) ;
    public final EObject ruleReadExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayRule_0 = null;

        EObject this_CallRule_1 = null;

        EObject this_LiteralRule_2 = null;

        EObject this_ParanthesesRule_3 = null;

        EObject this_ReferenceRule_4 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:1942:2: ( (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) )
            // InternalGeneratorDSL.g:1943:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            {
            // InternalGeneratorDSL.g:1943:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            int alt28=5;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // InternalGeneratorDSL.g:1944:3: this_ArrayRule_0= ruleArrayRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReadExpressionRuleAccess().getArrayRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ArrayRule_0=ruleArrayRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ArrayRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:1956:3: this_CallRule_1= ruleCallRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReadExpressionRuleAccess().getCallRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CallRule_1=ruleCallRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CallRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:1968:3: this_LiteralRule_2= ruleLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReadExpressionRuleAccess().getLiteralRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralRule_2=ruleLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralRule_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalGeneratorDSL.g:1980:3: this_ParanthesesRule_3= ruleParanthesesRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReadExpressionRuleAccess().getParanthesesRuleParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParanthesesRule_3=ruleParanthesesRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParanthesesRule_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalGeneratorDSL.g:1992:3: this_ReferenceRule_4= ruleReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReadExpressionRuleAccess().getReferenceRuleParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ReferenceRule_4=ruleReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ReferenceRule_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReadExpressionRule"


    // $ANTLR start "entryRuleArrayRule"
    // InternalGeneratorDSL.g:2007:1: entryRuleArrayRule returns [EObject current=null] : iv_ruleArrayRule= ruleArrayRule EOF ;
    public final EObject entryRuleArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRule = null;


        try {
            // InternalGeneratorDSL.g:2007:50: (iv_ruleArrayRule= ruleArrayRule EOF )
            // InternalGeneratorDSL.g:2008:2: iv_ruleArrayRule= ruleArrayRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrayRule=ruleArrayRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayRule"


    // $ANTLR start "ruleArrayRule"
    // InternalGeneratorDSL.g:2014:1: ruleArrayRule returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2020:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' ) )
            // InternalGeneratorDSL.g:2021:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' )
            {
            // InternalGeneratorDSL.g:2021:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' )
            // InternalGeneratorDSL.g:2022:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']'
            {
            // InternalGeneratorDSL.g:2022:3: ()
            // InternalGeneratorDSL.g:2023:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getArrayRuleAccess().getArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,19,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalGeneratorDSL.g:2036:3: ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_STRING && LA30_0<=RULE_ID)||LA30_0==19||LA30_0==39||(LA30_0>=46 && LA30_0<=47)||(LA30_0>=49 && LA30_0<=50)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalGeneratorDSL.g:2037:4: ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )*
                    {
                    // InternalGeneratorDSL.g:2037:4: ( (lv_values_2_0= ruleReadExpressionRule ) )
                    // InternalGeneratorDSL.g:2038:5: (lv_values_2_0= ruleReadExpressionRule )
                    {
                    // InternalGeneratorDSL.g:2038:5: (lv_values_2_0= ruleReadExpressionRule )
                    // InternalGeneratorDSL.g:2039:6: lv_values_2_0= ruleReadExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesReadExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_values_2_0=ruleReadExpressionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getArrayRuleRule());
                      						}
                      						add(
                      							current,
                      							"values",
                      							lv_values_2_0,
                      							"de.evoal.languages.model.base.dsl.BaseLanguage.ReadExpressionRule");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalGeneratorDSL.g:2056:4: (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==24) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalGeneratorDSL.g:2057:5: otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,24,FOLLOW_19); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalGeneratorDSL.g:2061:5: ( (lv_values_4_0= ruleReadExpressionRule ) )
                    	    // InternalGeneratorDSL.g:2062:6: (lv_values_4_0= ruleReadExpressionRule )
                    	    {
                    	    // InternalGeneratorDSL.g:2062:6: (lv_values_4_0= ruleReadExpressionRule )
                    	    // InternalGeneratorDSL.g:2063:7: lv_values_4_0= ruleReadExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesReadExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_13);
                    	    lv_values_4_0=ruleReadExpressionRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getArrayRuleRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"values",
                    	      								lv_values_4_0,
                    	      								"de.evoal.languages.model.base.dsl.BaseLanguage.ReadExpressionRule");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getArrayRuleAccess().getRightSquareBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayRule"


    // $ANTLR start "entryRuleParanthesesRule"
    // InternalGeneratorDSL.g:2090:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalGeneratorDSL.g:2090:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalGeneratorDSL.g:2091:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParanthesesRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParanthesesRule=ruleParanthesesRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParanthesesRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParanthesesRule"


    // $ANTLR start "ruleParanthesesRule"
    // InternalGeneratorDSL.g:2097:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2103:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalGeneratorDSL.g:2104:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalGeneratorDSL.g:2104:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalGeneratorDSL.g:2105:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalGeneratorDSL.g:2109:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalGeneratorDSL.g:2110:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalGeneratorDSL.g:2110:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalGeneratorDSL.g:2111:5: lv_subExpression_1_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_44);
            lv_subExpression_1_0=ruleExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParanthesesRuleRule());
              					}
              					set(
              						current,
              						"subExpression",
              						lv_subExpression_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.ExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParanthesesRuleAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParanthesesRule"


    // $ANTLR start "entryRuleCallRule"
    // InternalGeneratorDSL.g:2136:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalGeneratorDSL.g:2136:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalGeneratorDSL.g:2137:2: iv_ruleCallRule= ruleCallRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCallRule=ruleCallRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCallRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallRule"


    // $ANTLR start "ruleCallRule"
    // InternalGeneratorDSL.g:2143:1: ruleCallRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleCallRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_parameters_4_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2149:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalGeneratorDSL.g:2150:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalGeneratorDSL.g:2150:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalGeneratorDSL.g:2151:3: ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalGeneratorDSL.g:2151:3: ( ( ruleQualifiedName ) )
            // InternalGeneratorDSL.g:2152:4: ( ruleQualifiedName )
            {
            // InternalGeneratorDSL.g:2152:4: ( ruleQualifiedName )
            // InternalGeneratorDSL.g:2153:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCallRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCallRuleAccess().getFunctionFunctionDefinitionCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_31);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,39,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalGeneratorDSL.g:2174:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_STRING && LA32_0<=RULE_ID)||LA32_0==19||LA32_0==39||LA32_0==44||(LA32_0>=46 && LA32_0<=47)||(LA32_0>=49 && LA32_0<=50)||(LA32_0>=71 && LA32_0<=72)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalGeneratorDSL.g:2175:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalGeneratorDSL.g:2175:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalGeneratorDSL.g:2176:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalGeneratorDSL.g:2176:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalGeneratorDSL.g:2177:6: lv_parameters_2_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_33);
                    lv_parameters_2_0=ruleExpressionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCallRuleRule());
                      						}
                      						add(
                      							current,
                      							"parameters",
                      							lv_parameters_2_0,
                      							"de.evoal.languages.model.base.dsl.BaseLanguage.ExpressionRule");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalGeneratorDSL.g:2194:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==24) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalGeneratorDSL.g:2195:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,24,FOLLOW_34); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalGeneratorDSL.g:2199:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalGeneratorDSL.g:2200:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalGeneratorDSL.g:2200:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalGeneratorDSL.g:2201:7: lv_parameters_4_0= ruleExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_33);
                    	    lv_parameters_4_0=ruleExpressionRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getCallRuleRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parameters",
                    	      								lv_parameters_4_0,
                    	      								"de.evoal.languages.model.base.dsl.BaseLanguage.ExpressionRule");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCallRuleAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallRule"


    // $ANTLR start "entryRuleValuelDefinitionReferenceRule"
    // InternalGeneratorDSL.g:2228:1: entryRuleValuelDefinitionReferenceRule returns [EObject current=null] : iv_ruleValuelDefinitionReferenceRule= ruleValuelDefinitionReferenceRule EOF ;
    public final EObject entryRuleValuelDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValuelDefinitionReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:2228:70: (iv_ruleValuelDefinitionReferenceRule= ruleValuelDefinitionReferenceRule EOF )
            // InternalGeneratorDSL.g:2229:2: iv_ruleValuelDefinitionReferenceRule= ruleValuelDefinitionReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValuelDefinitionReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValuelDefinitionReferenceRule=ruleValuelDefinitionReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValuelDefinitionReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValuelDefinitionReferenceRule"


    // $ANTLR start "ruleValuelDefinitionReferenceRule"
    // InternalGeneratorDSL.g:2235:1: ruleValuelDefinitionReferenceRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleValuelDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2241:2: ( ( ( ruleQualifiedName ) ) )
            // InternalGeneratorDSL.g:2242:2: ( ( ruleQualifiedName ) )
            {
            // InternalGeneratorDSL.g:2242:2: ( ( ruleQualifiedName ) )
            // InternalGeneratorDSL.g:2243:3: ( ruleQualifiedName )
            {
            // InternalGeneratorDSL.g:2243:3: ( ruleQualifiedName )
            // InternalGeneratorDSL.g:2244:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getValuelDefinitionReferenceRuleRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getValuelDefinitionReferenceRuleAccess().getDefinitionValueDefinitionCrossReference_0());
              			
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValuelDefinitionReferenceRule"


    // $ANTLR start "entryRuleTypeDefinitionReferenceRule"
    // InternalGeneratorDSL.g:2264:1: entryRuleTypeDefinitionReferenceRule returns [EObject current=null] : iv_ruleTypeDefinitionReferenceRule= ruleTypeDefinitionReferenceRule EOF ;
    public final EObject entryRuleTypeDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDefinitionReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:2264:68: (iv_ruleTypeDefinitionReferenceRule= ruleTypeDefinitionReferenceRule EOF )
            // InternalGeneratorDSL.g:2265:2: iv_ruleTypeDefinitionReferenceRule= ruleTypeDefinitionReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDefinitionReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeDefinitionReferenceRule=ruleTypeDefinitionReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDefinitionReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeDefinitionReferenceRule"


    // $ANTLR start "ruleTypeDefinitionReferenceRule"
    // InternalGeneratorDSL.g:2271:1: ruleTypeDefinitionReferenceRule returns [EObject current=null] : (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule ) ;
    public final EObject ruleTypeDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_BaseDataReferenceRule_0 = null;

        EObject this_StructuredDataDescriptionReferenceRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2277:2: ( (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule ) )
            // InternalGeneratorDSL.g:2278:2: (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule )
            {
            // InternalGeneratorDSL.g:2278:2: (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==46) ) {
                alt33=1;
            }
            else if ( (LA33_0==47) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalGeneratorDSL.g:2279:3: this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeDefinitionReferenceRuleAccess().getBaseDataReferenceRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BaseDataReferenceRule_0=ruleBaseDataReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BaseDataReferenceRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2291:3: this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeDefinitionReferenceRuleAccess().getStructuredDataDescriptionReferenceRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StructuredDataDescriptionReferenceRule_1=ruleStructuredDataDescriptionReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StructuredDataDescriptionReferenceRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeDefinitionReferenceRule"


    // $ANTLR start "entryRuleBaseDataReferenceRule"
    // InternalGeneratorDSL.g:2306:1: entryRuleBaseDataReferenceRule returns [EObject current=null] : iv_ruleBaseDataReferenceRule= ruleBaseDataReferenceRule EOF ;
    public final EObject entryRuleBaseDataReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseDataReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:2306:62: (iv_ruleBaseDataReferenceRule= ruleBaseDataReferenceRule EOF )
            // InternalGeneratorDSL.g:2307:2: iv_ruleBaseDataReferenceRule= ruleBaseDataReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBaseDataReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBaseDataReferenceRule=ruleBaseDataReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBaseDataReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBaseDataReferenceRule"


    // $ANTLR start "ruleBaseDataReferenceRule"
    // InternalGeneratorDSL.g:2313:1: ruleBaseDataReferenceRule returns [EObject current=null] : (otherlv_0= 'data' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleBaseDataReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2319:2: ( (otherlv_0= 'data' ( ( ruleQualifiedName ) ) ) )
            // InternalGeneratorDSL.g:2320:2: (otherlv_0= 'data' ( ( ruleQualifiedName ) ) )
            {
            // InternalGeneratorDSL.g:2320:2: (otherlv_0= 'data' ( ( ruleQualifiedName ) ) )
            // InternalGeneratorDSL.g:2321:3: otherlv_0= 'data' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBaseDataReferenceRuleAccess().getDataKeyword_0());
              		
            }
            // InternalGeneratorDSL.g:2325:3: ( ( ruleQualifiedName ) )
            // InternalGeneratorDSL.g:2326:4: ( ruleQualifiedName )
            {
            // InternalGeneratorDSL.g:2326:4: ( ruleQualifiedName )
            // InternalGeneratorDSL.g:2327:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBaseDataReferenceRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBaseDataReferenceRuleAccess().getDefinitionBaseDataDescriptionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBaseDataReferenceRule"


    // $ANTLR start "entryRuleStructuredDataDescriptionReferenceRule"
    // InternalGeneratorDSL.g:2348:1: entryRuleStructuredDataDescriptionReferenceRule returns [EObject current=null] : iv_ruleStructuredDataDescriptionReferenceRule= ruleStructuredDataDescriptionReferenceRule EOF ;
    public final EObject entryRuleStructuredDataDescriptionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataDescriptionReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:2348:79: (iv_ruleStructuredDataDescriptionReferenceRule= ruleStructuredDataDescriptionReferenceRule EOF )
            // InternalGeneratorDSL.g:2349:2: iv_ruleStructuredDataDescriptionReferenceRule= ruleStructuredDataDescriptionReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStructuredDataDescriptionReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStructuredDataDescriptionReferenceRule=ruleStructuredDataDescriptionReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStructuredDataDescriptionReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStructuredDataDescriptionReferenceRule"


    // $ANTLR start "ruleStructuredDataDescriptionReferenceRule"
    // InternalGeneratorDSL.g:2355:1: ruleStructuredDataDescriptionReferenceRule returns [EObject current=null] : (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleStructuredDataDescriptionReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2361:2: ( (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) )
            // InternalGeneratorDSL.g:2362:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            {
            // InternalGeneratorDSL.g:2362:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            // InternalGeneratorDSL.g:2363:3: otherlv_0= 'instance' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getInstanceKeyword_0());
              		
            }
            // InternalGeneratorDSL.g:2367:3: ( ( ruleQualifiedName ) )
            // InternalGeneratorDSL.g:2368:4: ( ruleQualifiedName )
            {
            // InternalGeneratorDSL.g:2368:4: ( ruleQualifiedName )
            // InternalGeneratorDSL.g:2369:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStructuredDataDescriptionReferenceRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getDefinitionStructuredDataDescriptionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStructuredDataDescriptionReferenceRule"


    // $ANTLR start "entryRuleLiteralRule"
    // InternalGeneratorDSL.g:2390:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2390:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalGeneratorDSL.g:2391:2: iv_ruleLiteralRule= ruleLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralRule=ruleLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralRule"


    // $ANTLR start "ruleLiteralRule"
    // InternalGeneratorDSL.g:2397:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;

        EObject this_InstanceLiteralRule_3 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2403:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule ) )
            // InternalGeneratorDSL.g:2404:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule )
            {
            // InternalGeneratorDSL.g:2404:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule )
            int alt34=4;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
            case RULE_INT:
                {
                alt34=1;
                }
                break;
            case RULE_STRING:
                {
                alt34=2;
                }
                break;
            case 49:
            case 50:
                {
                alt34=3;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt34=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalGeneratorDSL.g:2405:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralRuleAccess().getNumberLiteralRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NumberLiteralRule_0=ruleNumberLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NumberLiteralRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2417:3: this_StringLiteralRule_1= ruleStringLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralRuleAccess().getStringLiteralRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StringLiteralRule_1=ruleStringLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StringLiteralRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:2429:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralRuleAccess().getBooleanLiteralRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteralRule_2=ruleBooleanLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BooleanLiteralRule_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalGeneratorDSL.g:2441:3: this_InstanceLiteralRule_3= ruleInstanceLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralRuleAccess().getInstanceLiteralRuleParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_InstanceLiteralRule_3=ruleInstanceLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_InstanceLiteralRule_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralRule"


    // $ANTLR start "entryRuleInstanceLiteralRule"
    // InternalGeneratorDSL.g:2456:1: entryRuleInstanceLiteralRule returns [EObject current=null] : iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF ;
    public final EObject entryRuleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2456:60: (iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF )
            // InternalGeneratorDSL.g:2457:2: iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstanceLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInstanceLiteralRule=ruleInstanceLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstanceLiteralRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstanceLiteralRule"


    // $ANTLR start "ruleInstanceLiteralRule"
    // InternalGeneratorDSL.g:2463:1: ruleInstanceLiteralRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' ) ;
    public final EObject ruleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2469:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' ) )
            // InternalGeneratorDSL.g:2470:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )
            {
            // InternalGeneratorDSL.g:2470:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )
            // InternalGeneratorDSL.g:2471:3: ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}'
            {
            // InternalGeneratorDSL.g:2471:3: ( ( ruleQualifiedName ) )
            // InternalGeneratorDSL.g:2472:4: ( ruleQualifiedName )
            {
            // InternalGeneratorDSL.g:2472:4: ( ruleQualifiedName )
            // InternalGeneratorDSL.g:2473:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInstanceLiteralRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInstanceLiteralRuleAccess().getDefinitionClassDefinitionCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_5);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInstanceLiteralRuleAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalGeneratorDSL.g:2494:3: ( (lv_attributes_2_0= ruleAttributeRule ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_QUOTED_ID && LA35_0<=RULE_ID)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalGeneratorDSL.g:2495:4: (lv_attributes_2_0= ruleAttributeRule )
            	    {
            	    // InternalGeneratorDSL.g:2495:4: (lv_attributes_2_0= ruleAttributeRule )
            	    // InternalGeneratorDSL.g:2496:5: lv_attributes_2_0= ruleAttributeRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAttributeRuleParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_45);
            	    lv_attributes_2_0=ruleAttributeRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getInstanceLiteralRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"attributes",
            	      						lv_attributes_2_0,
            	      						"de.evoal.languages.model.base.dsl.BaseLanguage.AttributeRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            otherlv_3=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getInstanceLiteralRuleAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstanceLiteralRule"


    // $ANTLR start "entryRuleAttributeRule"
    // InternalGeneratorDSL.g:2521:1: entryRuleAttributeRule returns [EObject current=null] : iv_ruleAttributeRule= ruleAttributeRule EOF ;
    public final EObject entryRuleAttributeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeRule = null;


        try {
            // InternalGeneratorDSL.g:2521:54: (iv_ruleAttributeRule= ruleAttributeRule EOF )
            // InternalGeneratorDSL.g:2522:2: iv_ruleAttributeRule= ruleAttributeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAttributeRule=ruleAttributeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttributeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeRule"


    // $ANTLR start "ruleAttributeRule"
    // InternalGeneratorDSL.g:2528:1: ruleAttributeRule returns [EObject current=null] : ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttributeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2534:2: ( ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' ) )
            // InternalGeneratorDSL.g:2535:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' )
            {
            // InternalGeneratorDSL.g:2535:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' )
            // InternalGeneratorDSL.g:2536:3: ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';'
            {
            // InternalGeneratorDSL.g:2536:3: ( ( ruleStringOrId ) )
            // InternalGeneratorDSL.g:2537:4: ( ruleStringOrId )
            {
            // InternalGeneratorDSL.g:2537:4: ( ruleStringOrId )
            // InternalGeneratorDSL.g:2538:5: ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAttributeRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeRuleAccess().getDefinitionAttributeDefinitionCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_46);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,48,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1());
              		
            }
            // InternalGeneratorDSL.g:2559:3: ( (lv_value_2_0= ruleExpressionRule ) )
            // InternalGeneratorDSL.g:2560:4: (lv_value_2_0= ruleExpressionRule )
            {
            // InternalGeneratorDSL.g:2560:4: (lv_value_2_0= ruleExpressionRule )
            // InternalGeneratorDSL.g:2561:5: lv_value_2_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeRuleAccess().getValueExpressionRuleParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_value_2_0=ruleExpressionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttributeRuleRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.ExpressionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAttributeRuleAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeRule"


    // $ANTLR start "entryRuleNumberLiteralRule"
    // InternalGeneratorDSL.g:2586:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2586:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalGeneratorDSL.g:2587:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumberLiteralRule=ruleNumberLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberLiteralRule"


    // $ANTLR start "ruleNumberLiteralRule"
    // InternalGeneratorDSL.g:2593:1: ruleNumberLiteralRule returns [EObject current=null] : (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_RealLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2599:2: ( (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalGeneratorDSL.g:2600:2: (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalGeneratorDSL.g:2600:2: (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_DOUBLE) ) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_INT) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalGeneratorDSL.g:2601:3: this_RealLiteralRule_0= ruleRealLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RealLiteralRule_0=ruleRealLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RealLiteralRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2613:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IntegerLiteralRule_1=ruleIntegerLiteralRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IntegerLiteralRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberLiteralRule"


    // $ANTLR start "entryRuleRealLiteralRule"
    // InternalGeneratorDSL.g:2628:1: entryRuleRealLiteralRule returns [EObject current=null] : iv_ruleRealLiteralRule= ruleRealLiteralRule EOF ;
    public final EObject entryRuleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2628:56: (iv_ruleRealLiteralRule= ruleRealLiteralRule EOF )
            // InternalGeneratorDSL.g:2629:2: iv_ruleRealLiteralRule= ruleRealLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRealLiteralRule=ruleRealLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealLiteralRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealLiteralRule"


    // $ANTLR start "ruleRealLiteralRule"
    // InternalGeneratorDSL.g:2635:1: ruleRealLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2641:2: ( ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalGeneratorDSL.g:2642:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalGeneratorDSL.g:2642:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalGeneratorDSL.g:2643:3: ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalGeneratorDSL.g:2643:3: ( (lv_literal_0_0= RULE_DOUBLE ) )
            // InternalGeneratorDSL.g:2644:4: (lv_literal_0_0= RULE_DOUBLE )
            {
            // InternalGeneratorDSL.g:2644:4: (lv_literal_0_0= RULE_DOUBLE )
            // InternalGeneratorDSL.g:2645:5: lv_literal_0_0= RULE_DOUBLE
            {
            lv_literal_0_0=(Token)match(input,RULE_DOUBLE,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_literal_0_0, grammarAccess.getRealLiteralRuleAccess().getLiteralDOUBLETerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRealLiteralRuleRule());
              					}
              					setWithLastConsumed(
              						current,
              						"literal",
              						lv_literal_0_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.DOUBLE");
              				
            }

            }


            }

            // InternalGeneratorDSL.g:2661:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=76 && LA37_0<=95)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalGeneratorDSL.g:2662:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalGeneratorDSL.g:2662:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalGeneratorDSL.g:2663:5: lv_factor_1_0= ruleFactorRule
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRealLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_factor_1_0=ruleFactorRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getRealLiteralRuleRule());
                      					}
                      					set(
                      						current,
                      						"factor",
                      						lv_factor_1_0,
                      						"de.evoal.languages.model.base.dsl.BaseLanguage.FactorRule");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealLiteralRule"


    // $ANTLR start "entryRuleIntegerLiteralRule"
    // InternalGeneratorDSL.g:2684:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2684:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalGeneratorDSL.g:2685:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntegerLiteralRule=ruleIntegerLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerLiteralRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerLiteralRule"


    // $ANTLR start "ruleIntegerLiteralRule"
    // InternalGeneratorDSL.g:2691:1: ruleIntegerLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2697:2: ( ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalGeneratorDSL.g:2698:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalGeneratorDSL.g:2698:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalGeneratorDSL.g:2699:3: ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalGeneratorDSL.g:2699:3: ( (lv_literal_0_0= RULE_INT ) )
            // InternalGeneratorDSL.g:2700:4: (lv_literal_0_0= RULE_INT )
            {
            // InternalGeneratorDSL.g:2700:4: (lv_literal_0_0= RULE_INT )
            // InternalGeneratorDSL.g:2701:5: lv_literal_0_0= RULE_INT
            {
            lv_literal_0_0=(Token)match(input,RULE_INT,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_literal_0_0, grammarAccess.getIntegerLiteralRuleAccess().getLiteralINTTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getIntegerLiteralRuleRule());
              					}
              					setWithLastConsumed(
              						current,
              						"literal",
              						lv_literal_0_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.INT");
              				
            }

            }


            }

            // InternalGeneratorDSL.g:2717:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=76 && LA38_0<=95)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalGeneratorDSL.g:2718:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalGeneratorDSL.g:2718:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalGeneratorDSL.g:2719:5: lv_factor_1_0= ruleFactorRule
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getIntegerLiteralRuleAccess().getFactorFactorRuleEnumRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_factor_1_0=ruleFactorRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getIntegerLiteralRuleRule());
                      					}
                      					set(
                      						current,
                      						"factor",
                      						lv_factor_1_0,
                      						"de.evoal.languages.model.base.dsl.BaseLanguage.FactorRule");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerLiteralRule"


    // $ANTLR start "entryRuleStringLiteralRule"
    // InternalGeneratorDSL.g:2740:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2740:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalGeneratorDSL.g:2741:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteralRule=ruleStringLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteralRule"


    // $ANTLR start "ruleStringLiteralRule"
    // InternalGeneratorDSL.g:2747:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_literal_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2753:2: ( ( (lv_literal_0_0= RULE_STRING ) ) )
            // InternalGeneratorDSL.g:2754:2: ( (lv_literal_0_0= RULE_STRING ) )
            {
            // InternalGeneratorDSL.g:2754:2: ( (lv_literal_0_0= RULE_STRING ) )
            // InternalGeneratorDSL.g:2755:3: (lv_literal_0_0= RULE_STRING )
            {
            // InternalGeneratorDSL.g:2755:3: (lv_literal_0_0= RULE_STRING )
            // InternalGeneratorDSL.g:2756:4: lv_literal_0_0= RULE_STRING
            {
            lv_literal_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_literal_0_0, grammarAccess.getStringLiteralRuleAccess().getLiteralSTRINGTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getStringLiteralRuleRule());
              				}
              				setWithLastConsumed(
              					current,
              					"literal",
              					lv_literal_0_0,
              					"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteralRule"


    // $ANTLR start "entryRuleBooleanLiteralRule"
    // InternalGeneratorDSL.g:2775:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalGeneratorDSL.g:2775:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalGeneratorDSL.g:2776:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteralRule=ruleBooleanLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteralRule"


    // $ANTLR start "ruleBooleanLiteralRule"
    // InternalGeneratorDSL.g:2782:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:2788:2: ( ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalGeneratorDSL.g:2789:2: ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalGeneratorDSL.g:2789:2: ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalGeneratorDSL.g:2790:3: () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalGeneratorDSL.g:2790:3: ()
            // InternalGeneratorDSL.g:2791:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBooleanLiteralRuleAccess().getBooleanLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalGeneratorDSL.g:2800:3: ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==49) ) {
                alt39=1;
            }
            else if ( (LA39_0==50) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalGeneratorDSL.g:2801:4: ( (lv_literal_1_0= 'true' ) )
                    {
                    // InternalGeneratorDSL.g:2801:4: ( (lv_literal_1_0= 'true' ) )
                    // InternalGeneratorDSL.g:2802:5: (lv_literal_1_0= 'true' )
                    {
                    // InternalGeneratorDSL.g:2802:5: (lv_literal_1_0= 'true' )
                    // InternalGeneratorDSL.g:2803:6: lv_literal_1_0= 'true'
                    {
                    lv_literal_1_0=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_literal_1_0, grammarAccess.getBooleanLiteralRuleAccess().getLiteralTrueKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBooleanLiteralRuleRule());
                      						}
                      						setWithLastConsumed(current, "literal", lv_literal_1_0 != null, "true");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:2816:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralRuleAccess().getFalseKeyword_1_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteralRule"


    // $ANTLR start "entryRuleConstraintRule"
    // InternalGeneratorDSL.g:2825:1: entryRuleConstraintRule returns [EObject current=null] : iv_ruleConstraintRule= ruleConstraintRule EOF ;
    public final EObject entryRuleConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintRule = null;


        try {
            // InternalGeneratorDSL.g:2825:55: (iv_ruleConstraintRule= ruleConstraintRule EOF )
            // InternalGeneratorDSL.g:2826:2: iv_ruleConstraintRule= ruleConstraintRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstraintRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstraintRule=ruleConstraintRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstraintRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraintRule"


    // $ANTLR start "ruleConstraintRule"
    // InternalGeneratorDSL.g:2832:1: ruleConstraintRule returns [EObject current=null] : (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule ) ;
    public final EObject ruleConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_InstanceLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2838:2: ( (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule ) )
            // InternalGeneratorDSL.g:2839:2: (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule )
            {
            // InternalGeneratorDSL.g:2839:2: (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule )
            // InternalGeneratorDSL.g:2840:3: otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule
            {
            otherlv_0=(Token)match(input,51,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstraintRuleAccess().getCommercialAtKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConstraintRuleAccess().getInstanceLiteralRuleParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_2);
            this_InstanceLiteralRule_1=ruleInstanceLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_InstanceLiteralRule_1;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraintRule"


    // $ANTLR start "entryRuleAttributeDefinitionRule"
    // InternalGeneratorDSL.g:2859:1: entryRuleAttributeDefinitionRule returns [EObject current=null] : iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF ;
    public final EObject entryRuleAttributeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeDefinitionRule = null;


        try {
            // InternalGeneratorDSL.g:2859:64: (iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF )
            // InternalGeneratorDSL.g:2860:2: iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAttributeDefinitionRule=ruleAttributeDefinitionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttributeDefinitionRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeDefinitionRule"


    // $ANTLR start "ruleAttributeDefinitionRule"
    // InternalGeneratorDSL.g:2866:1: ruleAttributeDefinitionRule returns [EObject current=null] : ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' ) ;
    public final EObject ruleAttributeDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_optional_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_constraints_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_initialisation_6_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2872:2: ( ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' ) )
            // InternalGeneratorDSL.g:2873:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' )
            {
            // InternalGeneratorDSL.g:2873:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' )
            // InternalGeneratorDSL.g:2874:3: ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';'
            {
            // InternalGeneratorDSL.g:2874:3: ( (lv_constraints_0_0= ruleConstraintRule ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==51) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalGeneratorDSL.g:2875:4: (lv_constraints_0_0= ruleConstraintRule )
            	    {
            	    // InternalGeneratorDSL.g:2875:4: (lv_constraints_0_0= ruleConstraintRule )
            	    // InternalGeneratorDSL.g:2876:5: lv_constraints_0_0= ruleConstraintRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_48);
            	    lv_constraints_0_0=ruleConstraintRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getAttributeDefinitionRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"constraints",
            	      						lv_constraints_0_0,
            	      						"de.evoal.languages.model.base.dsl.BaseLanguage.ConstraintRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            // InternalGeneratorDSL.g:2893:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalGeneratorDSL.g:2894:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalGeneratorDSL.g:2894:4: (lv_name_1_0= ruleStringOrId )
            // InternalGeneratorDSL.g:2895:5: lv_name_1_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_49);
            lv_name_1_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttributeDefinitionRuleRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.StringOrId");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,52,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_2());
              		
            }
            // InternalGeneratorDSL.g:2916:3: ( (lv_optional_3_0= 'optional' ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==53) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalGeneratorDSL.g:2917:4: (lv_optional_3_0= 'optional' )
                    {
                    // InternalGeneratorDSL.g:2917:4: (lv_optional_3_0= 'optional' )
                    // InternalGeneratorDSL.g:2918:5: lv_optional_3_0= 'optional'
                    {
                    lv_optional_3_0=(Token)match(input,53,FOLLOW_50); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_optional_3_0, grammarAccess.getAttributeDefinitionRuleAccess().getOptionalOptionalKeyword_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getAttributeDefinitionRuleRule());
                      					}
                      					setWithLastConsumed(current, "optional", lv_optional_3_0 != null, "optional");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalGeneratorDSL.g:2930:3: ( (lv_type_4_0= ruleTypeRule ) )
            // InternalGeneratorDSL.g:2931:4: (lv_type_4_0= ruleTypeRule )
            {
            // InternalGeneratorDSL.g:2931:4: (lv_type_4_0= ruleTypeRule )
            // InternalGeneratorDSL.g:2932:5: lv_type_4_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_51);
            lv_type_4_0=ruleTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttributeDefinitionRuleRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_4_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.TypeRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGeneratorDSL.g:2949:3: (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==48) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalGeneratorDSL.g:2950:4: otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) )
                    {
                    otherlv_5=(Token)match(input,48,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_5_0());
                      			
                    }
                    // InternalGeneratorDSL.g:2954:4: ( (lv_initialisation_6_0= ruleExpressionRule ) )
                    // InternalGeneratorDSL.g:2955:5: (lv_initialisation_6_0= ruleExpressionRule )
                    {
                    // InternalGeneratorDSL.g:2955:5: (lv_initialisation_6_0= ruleExpressionRule )
                    // InternalGeneratorDSL.g:2956:6: lv_initialisation_6_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_15);
                    lv_initialisation_6_0=ruleExpressionRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAttributeDefinitionRuleRule());
                      						}
                      						set(
                      							current,
                      							"initialisation",
                      							lv_initialisation_6_0,
                      							"de.evoal.languages.model.base.dsl.BaseLanguage.ExpressionRule");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getAttributeDefinitionRuleAccess().getSemicolonKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeDefinitionRule"


    // $ANTLR start "entryRuleTypeRule"
    // InternalGeneratorDSL.g:2982:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // InternalGeneratorDSL.g:2982:49: (iv_ruleTypeRule= ruleTypeRule EOF )
            // InternalGeneratorDSL.g:2983:2: iv_ruleTypeRule= ruleTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeRule=ruleTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRule"


    // $ANTLR start "ruleTypeRule"
    // InternalGeneratorDSL.g:2989:1: ruleTypeRule returns [EObject current=null] : (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule ) ;
    public final EObject ruleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayTypeRule_0 = null;

        EObject this_BaseTypeRule_1 = null;

        EObject this_TypeReferenceRule_2 = null;

        EObject this_EnumReferenceRule_3 = null;

        EObject this_ExpressionTypeRule_4 = null;

        EObject this_LiteralTypeRule_5 = null;

        EObject this_DataTypeRule_6 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:2995:2: ( (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule ) )
            // InternalGeneratorDSL.g:2996:2: (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule )
            {
            // InternalGeneratorDSL.g:2996:2: (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule )
            int alt43=7;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt43=1;
                }
                break;
            case 56:
            case 58:
            case 59:
            case 60:
            case 61:
                {
                alt43=2;
                }
                break;
            case 47:
                {
                alt43=3;
                }
                break;
            case 54:
                {
                alt43=4;
                }
                break;
            case 57:
                {
                alt43=5;
                }
                break;
            case 55:
                {
                alt43=6;
                }
                break;
            case 46:
                {
                alt43=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalGeneratorDSL.g:2997:3: this_ArrayTypeRule_0= ruleArrayTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getArrayTypeRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ArrayTypeRule_0=ruleArrayTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ArrayTypeRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:3009:3: this_BaseTypeRule_1= ruleBaseTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getBaseTypeRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BaseTypeRule_1=ruleBaseTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BaseTypeRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:3021:3: this_TypeReferenceRule_2= ruleTypeReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getTypeReferenceRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeReferenceRule_2=ruleTypeReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeReferenceRule_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalGeneratorDSL.g:3033:3: this_EnumReferenceRule_3= ruleEnumReferenceRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getEnumReferenceRuleParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EnumReferenceRule_3=ruleEnumReferenceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EnumReferenceRule_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalGeneratorDSL.g:3045:3: this_ExpressionTypeRule_4= ruleExpressionTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getExpressionTypeRuleParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExpressionTypeRule_4=ruleExpressionTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExpressionTypeRule_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalGeneratorDSL.g:3057:3: this_LiteralTypeRule_5= ruleLiteralTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getLiteralTypeRuleParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralTypeRule_5=ruleLiteralTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralTypeRule_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalGeneratorDSL.g:3069:3: this_DataTypeRule_6= ruleDataTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRuleAccess().getDataTypeRuleParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DataTypeRule_6=ruleDataTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DataTypeRule_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeRule"


    // $ANTLR start "entryRuleBaseTypeRule"
    // InternalGeneratorDSL.g:3084:1: entryRuleBaseTypeRule returns [EObject current=null] : iv_ruleBaseTypeRule= ruleBaseTypeRule EOF ;
    public final EObject entryRuleBaseTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseTypeRule = null;


        try {
            // InternalGeneratorDSL.g:3084:53: (iv_ruleBaseTypeRule= ruleBaseTypeRule EOF )
            // InternalGeneratorDSL.g:3085:2: iv_ruleBaseTypeRule= ruleBaseTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBaseTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBaseTypeRule=ruleBaseTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBaseTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBaseTypeRule"


    // $ANTLR start "ruleBaseTypeRule"
    // InternalGeneratorDSL.g:3091:1: ruleBaseTypeRule returns [EObject current=null] : (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule ) ;
    public final EObject ruleBaseTypeRule() throws RecognitionException {
        EObject current = null;

        EObject this_StringTypeRule_0 = null;

        EObject this_IntTypeRule_1 = null;

        EObject this_RealTypeRule_2 = null;

        EObject this_BooleanTypeRule_3 = null;

        EObject this_VoidTypeRule_4 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:3097:2: ( (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule ) )
            // InternalGeneratorDSL.g:3098:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule )
            {
            // InternalGeneratorDSL.g:3098:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule )
            int alt44=5;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt44=1;
                }
                break;
            case 58:
                {
                alt44=2;
                }
                break;
            case 59:
                {
                alt44=3;
                }
                break;
            case 60:
                {
                alt44=4;
                }
                break;
            case 61:
                {
                alt44=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalGeneratorDSL.g:3099:3: this_StringTypeRule_0= ruleStringTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBaseTypeRuleAccess().getStringTypeRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StringTypeRule_0=ruleStringTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StringTypeRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:3111:3: this_IntTypeRule_1= ruleIntTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBaseTypeRuleAccess().getIntTypeRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IntTypeRule_1=ruleIntTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IntTypeRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:3123:3: this_RealTypeRule_2= ruleRealTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBaseTypeRuleAccess().getRealTypeRuleParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RealTypeRule_2=ruleRealTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RealTypeRule_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalGeneratorDSL.g:3135:3: this_BooleanTypeRule_3= ruleBooleanTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBaseTypeRuleAccess().getBooleanTypeRuleParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BooleanTypeRule_3=ruleBooleanTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BooleanTypeRule_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalGeneratorDSL.g:3147:3: this_VoidTypeRule_4= ruleVoidTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBaseTypeRuleAccess().getVoidTypeRuleParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VoidTypeRule_4=ruleVoidTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VoidTypeRule_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBaseTypeRule"


    // $ANTLR start "entryRuleEnumReferenceRule"
    // InternalGeneratorDSL.g:3162:1: entryRuleEnumReferenceRule returns [EObject current=null] : iv_ruleEnumReferenceRule= ruleEnumReferenceRule EOF ;
    public final EObject entryRuleEnumReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:3162:58: (iv_ruleEnumReferenceRule= ruleEnumReferenceRule EOF )
            // InternalGeneratorDSL.g:3163:2: iv_ruleEnumReferenceRule= ruleEnumReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumReferenceRule=ruleEnumReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumReferenceRule"


    // $ANTLR start "ruleEnumReferenceRule"
    // InternalGeneratorDSL.g:3169:1: ruleEnumReferenceRule returns [EObject current=null] : (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleEnumReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:3175:2: ( (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) ) )
            // InternalGeneratorDSL.g:3176:2: (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) )
            {
            // InternalGeneratorDSL.g:3176:2: (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) )
            // InternalGeneratorDSL.g:3177:3: otherlv_0= 'enum' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumReferenceRuleAccess().getEnumKeyword_0());
              		
            }
            // InternalGeneratorDSL.g:3181:3: ( ( ruleQualifiedName ) )
            // InternalGeneratorDSL.g:3182:4: ( ruleQualifiedName )
            {
            // InternalGeneratorDSL.g:3182:4: ( ruleQualifiedName )
            // InternalGeneratorDSL.g:3183:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumReferenceRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumReferenceRuleAccess().getDefinitionEnumDefinitionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumReferenceRule"


    // $ANTLR start "entryRuleTypeReferenceRule"
    // InternalGeneratorDSL.g:3204:1: entryRuleTypeReferenceRule returns [EObject current=null] : iv_ruleTypeReferenceRule= ruleTypeReferenceRule EOF ;
    public final EObject entryRuleTypeReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReferenceRule = null;


        try {
            // InternalGeneratorDSL.g:3204:58: (iv_ruleTypeReferenceRule= ruleTypeReferenceRule EOF )
            // InternalGeneratorDSL.g:3205:2: iv_ruleTypeReferenceRule= ruleTypeReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeReferenceRule=ruleTypeReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReferenceRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeReferenceRule"


    // $ANTLR start "ruleTypeReferenceRule"
    // InternalGeneratorDSL.g:3211:1: ruleTypeReferenceRule returns [EObject current=null] : (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleTypeReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:3217:2: ( (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) )
            // InternalGeneratorDSL.g:3218:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            {
            // InternalGeneratorDSL.g:3218:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            // InternalGeneratorDSL.g:3219:3: otherlv_0= 'instance' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeReferenceRuleAccess().getInstanceKeyword_0());
              		
            }
            // InternalGeneratorDSL.g:3223:3: ( ( ruleQualifiedName ) )
            // InternalGeneratorDSL.g:3224:4: ( ruleQualifiedName )
            {
            // InternalGeneratorDSL.g:3224:4: ( ruleQualifiedName )
            // InternalGeneratorDSL.g:3225:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTypeReferenceRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeReferenceRuleAccess().getDefinitionClassDefinitionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeReferenceRule"


    // $ANTLR start "entryRuleLiteralTypeRule"
    // InternalGeneratorDSL.g:3246:1: entryRuleLiteralTypeRule returns [EObject current=null] : iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF ;
    public final EObject entryRuleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralTypeRule = null;


        try {
            // InternalGeneratorDSL.g:3246:56: (iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF )
            // InternalGeneratorDSL.g:3247:2: iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralTypeRule=ruleLiteralTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralTypeRule"


    // $ANTLR start "ruleLiteralTypeRule"
    // InternalGeneratorDSL.g:3253:1: ruleLiteralTypeRule returns [EObject current=null] : ( () otherlv_1= 'literal' ) ;
    public final EObject ruleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:3259:2: ( ( () otherlv_1= 'literal' ) )
            // InternalGeneratorDSL.g:3260:2: ( () otherlv_1= 'literal' )
            {
            // InternalGeneratorDSL.g:3260:2: ( () otherlv_1= 'literal' )
            // InternalGeneratorDSL.g:3261:3: () otherlv_1= 'literal'
            {
            // InternalGeneratorDSL.g:3261:3: ()
            // InternalGeneratorDSL.g:3262:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralTypeRuleAccess().getLiteralTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLiteralTypeRuleAccess().getLiteralKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralTypeRule"


    // $ANTLR start "entryRuleDataTypeRule"
    // InternalGeneratorDSL.g:3279:1: entryRuleDataTypeRule returns [EObject current=null] : iv_ruleDataTypeRule= ruleDataTypeRule EOF ;
    public final EObject entryRuleDataTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeRule = null;


        try {
            // InternalGeneratorDSL.g:3279:53: (iv_ruleDataTypeRule= ruleDataTypeRule EOF )
            // InternalGeneratorDSL.g:3280:2: iv_ruleDataTypeRule= ruleDataTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDataTypeRule=ruleDataTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataTypeRule"


    // $ANTLR start "ruleDataTypeRule"
    // InternalGeneratorDSL.g:3286:1: ruleDataTypeRule returns [EObject current=null] : ( () otherlv_1= 'data' ) ;
    public final EObject ruleDataTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:3292:2: ( ( () otherlv_1= 'data' ) )
            // InternalGeneratorDSL.g:3293:2: ( () otherlv_1= 'data' )
            {
            // InternalGeneratorDSL.g:3293:2: ( () otherlv_1= 'data' )
            // InternalGeneratorDSL.g:3294:3: () otherlv_1= 'data'
            {
            // InternalGeneratorDSL.g:3294:3: ()
            // InternalGeneratorDSL.g:3295:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDataTypeRuleAccess().getDataTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDataTypeRuleAccess().getDataKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataTypeRule"


    // $ANTLR start "entryRuleStringTypeRule"
    // InternalGeneratorDSL.g:3312:1: entryRuleStringTypeRule returns [EObject current=null] : iv_ruleStringTypeRule= ruleStringTypeRule EOF ;
    public final EObject entryRuleStringTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeRule = null;


        try {
            // InternalGeneratorDSL.g:3312:55: (iv_ruleStringTypeRule= ruleStringTypeRule EOF )
            // InternalGeneratorDSL.g:3313:2: iv_ruleStringTypeRule= ruleStringTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringTypeRule=ruleStringTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringTypeRule"


    // $ANTLR start "ruleStringTypeRule"
    // InternalGeneratorDSL.g:3319:1: ruleStringTypeRule returns [EObject current=null] : ( () otherlv_1= 'string' ) ;
    public final EObject ruleStringTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:3325:2: ( ( () otherlv_1= 'string' ) )
            // InternalGeneratorDSL.g:3326:2: ( () otherlv_1= 'string' )
            {
            // InternalGeneratorDSL.g:3326:2: ( () otherlv_1= 'string' )
            // InternalGeneratorDSL.g:3327:3: () otherlv_1= 'string'
            {
            // InternalGeneratorDSL.g:3327:3: ()
            // InternalGeneratorDSL.g:3328:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStringTypeRuleAccess().getStringTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStringTypeRuleAccess().getStringKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringTypeRule"


    // $ANTLR start "entryRuleExpressionTypeRule"
    // InternalGeneratorDSL.g:3345:1: entryRuleExpressionTypeRule returns [EObject current=null] : iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF ;
    public final EObject entryRuleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionTypeRule = null;


        try {
            // InternalGeneratorDSL.g:3345:59: (iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF )
            // InternalGeneratorDSL.g:3346:2: iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionTypeRule=ruleExpressionTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionTypeRule"


    // $ANTLR start "ruleExpressionTypeRule"
    // InternalGeneratorDSL.g:3352:1: ruleExpressionTypeRule returns [EObject current=null] : ( () otherlv_1= 'expression' ) ;
    public final EObject ruleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:3358:2: ( ( () otherlv_1= 'expression' ) )
            // InternalGeneratorDSL.g:3359:2: ( () otherlv_1= 'expression' )
            {
            // InternalGeneratorDSL.g:3359:2: ( () otherlv_1= 'expression' )
            // InternalGeneratorDSL.g:3360:3: () otherlv_1= 'expression'
            {
            // InternalGeneratorDSL.g:3360:3: ()
            // InternalGeneratorDSL.g:3361:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExpressionTypeRuleAccess().getExpressionTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getExpressionTypeRuleAccess().getExpressionKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionTypeRule"


    // $ANTLR start "entryRuleIntTypeRule"
    // InternalGeneratorDSL.g:3378:1: entryRuleIntTypeRule returns [EObject current=null] : iv_ruleIntTypeRule= ruleIntTypeRule EOF ;
    public final EObject entryRuleIntTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntTypeRule = null;


        try {
            // InternalGeneratorDSL.g:3378:52: (iv_ruleIntTypeRule= ruleIntTypeRule EOF )
            // InternalGeneratorDSL.g:3379:2: iv_ruleIntTypeRule= ruleIntTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntTypeRule=ruleIntTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntTypeRule"


    // $ANTLR start "ruleIntTypeRule"
    // InternalGeneratorDSL.g:3385:1: ruleIntTypeRule returns [EObject current=null] : ( () otherlv_1= 'int' ) ;
    public final EObject ruleIntTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:3391:2: ( ( () otherlv_1= 'int' ) )
            // InternalGeneratorDSL.g:3392:2: ( () otherlv_1= 'int' )
            {
            // InternalGeneratorDSL.g:3392:2: ( () otherlv_1= 'int' )
            // InternalGeneratorDSL.g:3393:3: () otherlv_1= 'int'
            {
            // InternalGeneratorDSL.g:3393:3: ()
            // InternalGeneratorDSL.g:3394:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getIntTypeRuleAccess().getIntTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIntTypeRuleAccess().getIntKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntTypeRule"


    // $ANTLR start "entryRuleRealTypeRule"
    // InternalGeneratorDSL.g:3411:1: entryRuleRealTypeRule returns [EObject current=null] : iv_ruleRealTypeRule= ruleRealTypeRule EOF ;
    public final EObject entryRuleRealTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTypeRule = null;


        try {
            // InternalGeneratorDSL.g:3411:53: (iv_ruleRealTypeRule= ruleRealTypeRule EOF )
            // InternalGeneratorDSL.g:3412:2: iv_ruleRealTypeRule= ruleRealTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRealTypeRule=ruleRealTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealTypeRule"


    // $ANTLR start "ruleRealTypeRule"
    // InternalGeneratorDSL.g:3418:1: ruleRealTypeRule returns [EObject current=null] : ( () otherlv_1= 'real' ) ;
    public final EObject ruleRealTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:3424:2: ( ( () otherlv_1= 'real' ) )
            // InternalGeneratorDSL.g:3425:2: ( () otherlv_1= 'real' )
            {
            // InternalGeneratorDSL.g:3425:2: ( () otherlv_1= 'real' )
            // InternalGeneratorDSL.g:3426:3: () otherlv_1= 'real'
            {
            // InternalGeneratorDSL.g:3426:3: ()
            // InternalGeneratorDSL.g:3427:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRealTypeRuleAccess().getRealTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRealTypeRuleAccess().getRealKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealTypeRule"


    // $ANTLR start "entryRuleBooleanTypeRule"
    // InternalGeneratorDSL.g:3444:1: entryRuleBooleanTypeRule returns [EObject current=null] : iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF ;
    public final EObject entryRuleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeRule = null;


        try {
            // InternalGeneratorDSL.g:3444:56: (iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF )
            // InternalGeneratorDSL.g:3445:2: iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanTypeRule=ruleBooleanTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanTypeRule"


    // $ANTLR start "ruleBooleanTypeRule"
    // InternalGeneratorDSL.g:3451:1: ruleBooleanTypeRule returns [EObject current=null] : ( () otherlv_1= 'boolean' ) ;
    public final EObject ruleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:3457:2: ( ( () otherlv_1= 'boolean' ) )
            // InternalGeneratorDSL.g:3458:2: ( () otherlv_1= 'boolean' )
            {
            // InternalGeneratorDSL.g:3458:2: ( () otherlv_1= 'boolean' )
            // InternalGeneratorDSL.g:3459:3: () otherlv_1= 'boolean'
            {
            // InternalGeneratorDSL.g:3459:3: ()
            // InternalGeneratorDSL.g:3460:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBooleanTypeRuleAccess().getBooleanTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBooleanTypeRuleAccess().getBooleanKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanTypeRule"


    // $ANTLR start "entryRuleVoidTypeRule"
    // InternalGeneratorDSL.g:3477:1: entryRuleVoidTypeRule returns [EObject current=null] : iv_ruleVoidTypeRule= ruleVoidTypeRule EOF ;
    public final EObject entryRuleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoidTypeRule = null;


        try {
            // InternalGeneratorDSL.g:3477:53: (iv_ruleVoidTypeRule= ruleVoidTypeRule EOF )
            // InternalGeneratorDSL.g:3478:2: iv_ruleVoidTypeRule= ruleVoidTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVoidTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVoidTypeRule=ruleVoidTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVoidTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVoidTypeRule"


    // $ANTLR start "ruleVoidTypeRule"
    // InternalGeneratorDSL.g:3484:1: ruleVoidTypeRule returns [EObject current=null] : ( () otherlv_1= 'void' ) ;
    public final EObject ruleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:3490:2: ( ( () otherlv_1= 'void' ) )
            // InternalGeneratorDSL.g:3491:2: ( () otherlv_1= 'void' )
            {
            // InternalGeneratorDSL.g:3491:2: ( () otherlv_1= 'void' )
            // InternalGeneratorDSL.g:3492:3: () otherlv_1= 'void'
            {
            // InternalGeneratorDSL.g:3492:3: ()
            // InternalGeneratorDSL.g:3493:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVoidTypeRuleAccess().getVoidTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getVoidTypeRuleAccess().getVoidKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVoidTypeRule"


    // $ANTLR start "entryRuleArrayTypeRule"
    // InternalGeneratorDSL.g:3510:1: entryRuleArrayTypeRule returns [EObject current=null] : iv_ruleArrayTypeRule= ruleArrayTypeRule EOF ;
    public final EObject entryRuleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayTypeRule = null;


        try {
            // InternalGeneratorDSL.g:3510:54: (iv_ruleArrayTypeRule= ruleArrayTypeRule EOF )
            // InternalGeneratorDSL.g:3511:2: iv_ruleArrayTypeRule= ruleArrayTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrayTypeRule=ruleArrayTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayTypeRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayTypeRule"


    // $ANTLR start "ruleArrayTypeRule"
    // InternalGeneratorDSL.g:3517:1: ruleArrayTypeRule returns [EObject current=null] : (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) ;
    public final EObject ruleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:3523:2: ( (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) )
            // InternalGeneratorDSL.g:3524:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            {
            // InternalGeneratorDSL.g:3524:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            // InternalGeneratorDSL.g:3525:3: otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) )
            {
            otherlv_0=(Token)match(input,62,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0());
              		
            }
            // InternalGeneratorDSL.g:3529:3: ( (lv_elements_1_0= ruleTypeRule ) )
            // InternalGeneratorDSL.g:3530:4: (lv_elements_1_0= ruleTypeRule )
            {
            // InternalGeneratorDSL.g:3530:4: (lv_elements_1_0= ruleTypeRule )
            // InternalGeneratorDSL.g:3531:5: lv_elements_1_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArrayTypeRuleAccess().getElementsTypeRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_elements_1_0=ruleTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getArrayTypeRuleRule());
              					}
              					set(
              						current,
              						"elements",
              						lv_elements_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.TypeRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayTypeRule"


    // $ANTLR start "entryRuleParameterRule"
    // InternalGeneratorDSL.g:3552:1: entryRuleParameterRule returns [EObject current=null] : iv_ruleParameterRule= ruleParameterRule EOF ;
    public final EObject entryRuleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRule = null;


        try {
            // InternalGeneratorDSL.g:3552:54: (iv_ruleParameterRule= ruleParameterRule EOF )
            // InternalGeneratorDSL.g:3553:2: iv_ruleParameterRule= ruleParameterRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterRule=ruleParameterRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterRule"


    // $ANTLR start "ruleParameterRule"
    // InternalGeneratorDSL.g:3559:1: ruleParameterRule returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) ;
    public final EObject ruleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:3565:2: ( ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) )
            // InternalGeneratorDSL.g:3566:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            {
            // InternalGeneratorDSL.g:3566:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            // InternalGeneratorDSL.g:3567:3: ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) )
            {
            // InternalGeneratorDSL.g:3567:3: ( (lv_type_0_0= ruleTypeRule ) )
            // InternalGeneratorDSL.g:3568:4: (lv_type_0_0= ruleTypeRule )
            {
            // InternalGeneratorDSL.g:3568:4: (lv_type_0_0= ruleTypeRule )
            // InternalGeneratorDSL.g:3569:5: lv_type_0_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterRuleAccess().getTypeTypeRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_4);
            lv_type_0_0=ruleTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterRuleRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.TypeRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGeneratorDSL.g:3586:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalGeneratorDSL.g:3587:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalGeneratorDSL.g:3587:4: (lv_name_1_0= ruleStringOrId )
            // InternalGeneratorDSL.g:3588:5: lv_name_1_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterRuleAccess().getNameStringOrIdParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterRuleRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.StringOrId");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterRule"


    // $ANTLR start "entryRuleImportRule"
    // InternalGeneratorDSL.g:3609:1: entryRuleImportRule returns [EObject current=null] : iv_ruleImportRule= ruleImportRule EOF ;
    public final EObject entryRuleImportRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportRule = null;


        try {
            // InternalGeneratorDSL.g:3609:51: (iv_ruleImportRule= ruleImportRule EOF )
            // InternalGeneratorDSL.g:3610:2: iv_ruleImportRule= ruleImportRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImportRule=ruleImportRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportRule"


    // $ANTLR start "ruleImportRule"
    // InternalGeneratorDSL.g:3616:1: ruleImportRule returns [EObject current=null] : (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' ) ;
    public final EObject ruleImportRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_language_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_importedNamespace_3_0 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:3622:2: ( (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' ) )
            // InternalGeneratorDSL.g:3623:2: (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' )
            {
            // InternalGeneratorDSL.g:3623:2: (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' )
            // InternalGeneratorDSL.g:3624:3: otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportRuleAccess().getImportKeyword_0());
              		
            }
            // InternalGeneratorDSL.g:3628:3: ( (lv_language_1_0= RULE_STRING ) )
            // InternalGeneratorDSL.g:3629:4: (lv_language_1_0= RULE_STRING )
            {
            // InternalGeneratorDSL.g:3629:4: (lv_language_1_0= RULE_STRING )
            // InternalGeneratorDSL.g:3630:5: lv_language_1_0= RULE_STRING
            {
            lv_language_1_0=(Token)match(input,RULE_STRING,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_language_1_0, grammarAccess.getImportRuleAccess().getLanguageSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportRuleRule());
              					}
              					setWithLastConsumed(
              						current,
              						"language",
              						lv_language_1_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,37,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getImportRuleAccess().getFromKeyword_2());
              		
            }
            // InternalGeneratorDSL.g:3650:3: ( (lv_importedNamespace_3_0= ruleQualifiedName ) )
            // InternalGeneratorDSL.g:3651:4: (lv_importedNamespace_3_0= ruleQualifiedName )
            {
            // InternalGeneratorDSL.g:3651:4: (lv_importedNamespace_3_0= ruleQualifiedName )
            // InternalGeneratorDSL.g:3652:5: lv_importedNamespace_3_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getImportRuleAccess().getImportedNamespaceQualifiedNameParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_importedNamespace_3_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getImportRuleRule());
              					}
              					set(
              						current,
              						"importedNamespace",
              						lv_importedNamespace_3_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.QualifiedName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getImportRuleAccess().getSemicolonKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportRule"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalGeneratorDSL.g:3677:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalGeneratorDSL.g:3677:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalGeneratorDSL.g:3678:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalGeneratorDSL.g:3684:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_StringOrId_0 = null;

        AntlrDatatypeRuleToken this_StringOrId_2 = null;



        	enterRule();

        try {
            // InternalGeneratorDSL.g:3690:2: ( (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) )
            // InternalGeneratorDSL.g:3691:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            {
            // InternalGeneratorDSL.g:3691:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            // InternalGeneratorDSL.g:3692:3: this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_52);
            this_StringOrId_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_StringOrId_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalGeneratorDSL.g:3702:3: (kw= '.' this_StringOrId_2= ruleStringOrId )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==64) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalGeneratorDSL.g:3703:4: kw= '.' this_StringOrId_2= ruleStringOrId
            	    {
            	    kw=(Token)match(input,64,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_52);
            	    this_StringOrId_2=ruleStringOrId();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_StringOrId_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleStringOrId"
    // InternalGeneratorDSL.g:3723:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalGeneratorDSL.g:3723:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalGeneratorDSL.g:3724:2: iv_ruleStringOrId= ruleStringOrId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringOrIdRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringOrId=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringOrId.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringOrId"


    // $ANTLR start "ruleStringOrId"
    // InternalGeneratorDSL.g:3730:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:3736:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalGeneratorDSL.g:3737:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalGeneratorDSL.g:3737:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_QUOTED_ID) ) {
                alt46=1;
            }
            else if ( (LA46_0==RULE_ID) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalGeneratorDSL.g:3738:3: this_QUOTED_ID_0= RULE_QUOTED_ID
                    {
                    this_QUOTED_ID_0=(Token)match(input,RULE_QUOTED_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_QUOTED_ID_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_QUOTED_ID_0, grammarAccess.getStringOrIdAccess().getQUOTED_IDTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:3746:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_1, grammarAccess.getStringOrIdAccess().getIDTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringOrId"


    // $ANTLR start "ruleComparisonOperatorRule"
    // InternalGeneratorDSL.g:3757:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
    public final Enumerator ruleComparisonOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:3763:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalGeneratorDSL.g:3764:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalGeneratorDSL.g:3764:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt47=6;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt47=1;
                }
                break;
            case 66:
                {
                alt47=2;
                }
                break;
            case 67:
                {
                alt47=3;
                }
                break;
            case 68:
                {
                alt47=4;
                }
                break;
            case 69:
                {
                alt47=5;
                }
                break;
            case 70:
                {
                alt47=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalGeneratorDSL.g:3765:3: (enumLiteral_0= '>=' )
                    {
                    // InternalGeneratorDSL.g:3765:3: (enumLiteral_0= '>=' )
                    // InternalGeneratorDSL.g:3766:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:3773:3: (enumLiteral_1= '>' )
                    {
                    // InternalGeneratorDSL.g:3773:3: (enumLiteral_1= '>' )
                    // InternalGeneratorDSL.g:3774:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:3781:3: (enumLiteral_2= '=' )
                    {
                    // InternalGeneratorDSL.g:3781:3: (enumLiteral_2= '=' )
                    // InternalGeneratorDSL.g:3782:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalGeneratorDSL.g:3789:3: (enumLiteral_3= '!=' )
                    {
                    // InternalGeneratorDSL.g:3789:3: (enumLiteral_3= '!=' )
                    // InternalGeneratorDSL.g:3790:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalGeneratorDSL.g:3797:3: (enumLiteral_4= '<' )
                    {
                    // InternalGeneratorDSL.g:3797:3: (enumLiteral_4= '<' )
                    // InternalGeneratorDSL.g:3798:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalGeneratorDSL.g:3805:3: (enumLiteral_5= '<=' )
                    {
                    // InternalGeneratorDSL.g:3805:3: (enumLiteral_5= '<=' )
                    // InternalGeneratorDSL.g:3806:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getComparisonOperatorRuleAccess().getLessThanEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparisonOperatorRule"


    // $ANTLR start "ruleAddOrSubtractOperatorRule"
    // InternalGeneratorDSL.g:3816:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:3822:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalGeneratorDSL.g:3823:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalGeneratorDSL.g:3823:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==71) ) {
                alt48=1;
            }
            else if ( (LA48_0==72) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalGeneratorDSL.g:3824:3: (enumLiteral_0= '+' )
                    {
                    // InternalGeneratorDSL.g:3824:3: (enumLiteral_0= '+' )
                    // InternalGeneratorDSL.g:3825:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:3832:3: (enumLiteral_1= '-' )
                    {
                    // InternalGeneratorDSL.g:3832:3: (enumLiteral_1= '-' )
                    // InternalGeneratorDSL.g:3833:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAddOrSubtractOperatorRuleAccess().getSubtractEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddOrSubtractOperatorRule"


    // $ANTLR start "ruleMultiplyDivideModuloOperatorRule"
    // InternalGeneratorDSL.g:3843:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:3849:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalGeneratorDSL.g:3850:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalGeneratorDSL.g:3850:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt49=3;
            switch ( input.LA(1) ) {
            case 73:
                {
                alt49=1;
                }
                break;
            case 74:
                {
                alt49=2;
                }
                break;
            case 75:
                {
                alt49=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalGeneratorDSL.g:3851:3: (enumLiteral_0= '*' )
                    {
                    // InternalGeneratorDSL.g:3851:3: (enumLiteral_0= '*' )
                    // InternalGeneratorDSL.g:3852:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:3859:3: (enumLiteral_1= '/' )
                    {
                    // InternalGeneratorDSL.g:3859:3: (enumLiteral_1= '/' )
                    // InternalGeneratorDSL.g:3860:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:3867:3: (enumLiteral_2= '%' )
                    {
                    // InternalGeneratorDSL.g:3867:3: (enumLiteral_2= '%' )
                    // InternalGeneratorDSL.g:3868:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getModuloEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplyDivideModuloOperatorRule"


    // $ANTLR start "ruleFactorRule"
    // InternalGeneratorDSL.g:3878:1: ruleFactorRule returns [Enumerator current=null] : ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) ;
    public final Enumerator ruleFactorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;


        	enterRule();

        try {
            // InternalGeneratorDSL.g:3884:2: ( ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) )
            // InternalGeneratorDSL.g:3885:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            {
            // InternalGeneratorDSL.g:3885:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            int alt50=20;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt50=1;
                }
                break;
            case 77:
                {
                alt50=2;
                }
                break;
            case 78:
                {
                alt50=3;
                }
                break;
            case 79:
                {
                alt50=4;
                }
                break;
            case 80:
                {
                alt50=5;
                }
                break;
            case 81:
                {
                alt50=6;
                }
                break;
            case 82:
                {
                alt50=7;
                }
                break;
            case 83:
                {
                alt50=8;
                }
                break;
            case 84:
                {
                alt50=9;
                }
                break;
            case 85:
                {
                alt50=10;
                }
                break;
            case 86:
                {
                alt50=11;
                }
                break;
            case 87:
                {
                alt50=12;
                }
                break;
            case 88:
                {
                alt50=13;
                }
                break;
            case 89:
                {
                alt50=14;
                }
                break;
            case 90:
                {
                alt50=15;
                }
                break;
            case 91:
                {
                alt50=16;
                }
                break;
            case 92:
                {
                alt50=17;
                }
                break;
            case 93:
                {
                alt50=18;
                }
                break;
            case 94:
                {
                alt50=19;
                }
                break;
            case 95:
                {
                alt50=20;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalGeneratorDSL.g:3886:3: (enumLiteral_0= 'Y' )
                    {
                    // InternalGeneratorDSL.g:3886:3: (enumLiteral_0= 'Y' )
                    // InternalGeneratorDSL.g:3887:4: enumLiteral_0= 'Y'
                    {
                    enumLiteral_0=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalGeneratorDSL.g:3894:3: (enumLiteral_1= 'Z' )
                    {
                    // InternalGeneratorDSL.g:3894:3: (enumLiteral_1= 'Z' )
                    // InternalGeneratorDSL.g:3895:4: enumLiteral_1= 'Z'
                    {
                    enumLiteral_1=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalGeneratorDSL.g:3902:3: (enumLiteral_2= 'E' )
                    {
                    // InternalGeneratorDSL.g:3902:3: (enumLiteral_2= 'E' )
                    // InternalGeneratorDSL.g:3903:4: enumLiteral_2= 'E'
                    {
                    enumLiteral_2=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalGeneratorDSL.g:3910:3: (enumLiteral_3= 'P' )
                    {
                    // InternalGeneratorDSL.g:3910:3: (enumLiteral_3= 'P' )
                    // InternalGeneratorDSL.g:3911:4: enumLiteral_3= 'P'
                    {
                    enumLiteral_3=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalGeneratorDSL.g:3918:3: (enumLiteral_4= 'T' )
                    {
                    // InternalGeneratorDSL.g:3918:3: (enumLiteral_4= 'T' )
                    // InternalGeneratorDSL.g:3919:4: enumLiteral_4= 'T'
                    {
                    enumLiteral_4=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalGeneratorDSL.g:3926:3: (enumLiteral_5= 'G' )
                    {
                    // InternalGeneratorDSL.g:3926:3: (enumLiteral_5= 'G' )
                    // InternalGeneratorDSL.g:3927:4: enumLiteral_5= 'G'
                    {
                    enumLiteral_5=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalGeneratorDSL.g:3934:3: (enumLiteral_6= 'M' )
                    {
                    // InternalGeneratorDSL.g:3934:3: (enumLiteral_6= 'M' )
                    // InternalGeneratorDSL.g:3935:4: enumLiteral_6= 'M'
                    {
                    enumLiteral_6=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalGeneratorDSL.g:3942:3: (enumLiteral_7= 'k' )
                    {
                    // InternalGeneratorDSL.g:3942:3: (enumLiteral_7= 'k' )
                    // InternalGeneratorDSL.g:3943:4: enumLiteral_7= 'k'
                    {
                    enumLiteral_7=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalGeneratorDSL.g:3950:3: (enumLiteral_8= 'h' )
                    {
                    // InternalGeneratorDSL.g:3950:3: (enumLiteral_8= 'h' )
                    // InternalGeneratorDSL.g:3951:4: enumLiteral_8= 'h'
                    {
                    enumLiteral_8=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalGeneratorDSL.g:3958:3: (enumLiteral_9= 'da' )
                    {
                    // InternalGeneratorDSL.g:3958:3: (enumLiteral_9= 'da' )
                    // InternalGeneratorDSL.g:3959:4: enumLiteral_9= 'da'
                    {
                    enumLiteral_9=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalGeneratorDSL.g:3966:3: (enumLiteral_10= 'd' )
                    {
                    // InternalGeneratorDSL.g:3966:3: (enumLiteral_10= 'd' )
                    // InternalGeneratorDSL.g:3967:4: enumLiteral_10= 'd'
                    {
                    enumLiteral_10=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalGeneratorDSL.g:3974:3: (enumLiteral_11= 'c' )
                    {
                    // InternalGeneratorDSL.g:3974:3: (enumLiteral_11= 'c' )
                    // InternalGeneratorDSL.g:3975:4: enumLiteral_11= 'c'
                    {
                    enumLiteral_11=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_11, grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11());
                      			
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalGeneratorDSL.g:3982:3: (enumLiteral_12= 'm' )
                    {
                    // InternalGeneratorDSL.g:3982:3: (enumLiteral_12= 'm' )
                    // InternalGeneratorDSL.g:3983:4: enumLiteral_12= 'm'
                    {
                    enumLiteral_12=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_12, grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12());
                      			
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalGeneratorDSL.g:3990:3: (enumLiteral_13= '\\u00B5' )
                    {
                    // InternalGeneratorDSL.g:3990:3: (enumLiteral_13= '\\u00B5' )
                    // InternalGeneratorDSL.g:3991:4: enumLiteral_13= '\\u00B5'
                    {
                    enumLiteral_13=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_13, grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13());
                      			
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalGeneratorDSL.g:3998:3: (enumLiteral_14= 'n' )
                    {
                    // InternalGeneratorDSL.g:3998:3: (enumLiteral_14= 'n' )
                    // InternalGeneratorDSL.g:3999:4: enumLiteral_14= 'n'
                    {
                    enumLiteral_14=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_14, grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14());
                      			
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalGeneratorDSL.g:4006:3: (enumLiteral_15= 'p' )
                    {
                    // InternalGeneratorDSL.g:4006:3: (enumLiteral_15= 'p' )
                    // InternalGeneratorDSL.g:4007:4: enumLiteral_15= 'p'
                    {
                    enumLiteral_15=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_15, grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15());
                      			
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalGeneratorDSL.g:4014:3: (enumLiteral_16= 'f' )
                    {
                    // InternalGeneratorDSL.g:4014:3: (enumLiteral_16= 'f' )
                    // InternalGeneratorDSL.g:4015:4: enumLiteral_16= 'f'
                    {
                    enumLiteral_16=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_16, grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16());
                      			
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalGeneratorDSL.g:4022:3: (enumLiteral_17= 'a' )
                    {
                    // InternalGeneratorDSL.g:4022:3: (enumLiteral_17= 'a' )
                    // InternalGeneratorDSL.g:4023:4: enumLiteral_17= 'a'
                    {
                    enumLiteral_17=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_17, grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17());
                      			
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalGeneratorDSL.g:4030:3: (enumLiteral_18= 'z' )
                    {
                    // InternalGeneratorDSL.g:4030:3: (enumLiteral_18= 'z' )
                    // InternalGeneratorDSL.g:4031:4: enumLiteral_18= 'z'
                    {
                    enumLiteral_18=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_18, grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18());
                      			
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalGeneratorDSL.g:4038:3: (enumLiteral_19= 'y' )
                    {
                    // InternalGeneratorDSL.g:4038:3: (enumLiteral_19= 'y' )
                    // InternalGeneratorDSL.g:4039:4: enumLiteral_19= 'y'
                    {
                    enumLiteral_19=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_19, grammarAccess.getFactorRuleAccess().getYoctoEnumLiteralDeclaration_19());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFactorRule"

    // $ANTLR start synpred17_InternalGeneratorDSL
    public final void synpred17_InternalGeneratorDSL_fragment() throws RecognitionException {   
        EObject this_ValuelDefinitionReferenceRule_0 = null;


        // InternalGeneratorDSL.g:1099:3: (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule )
        // InternalGeneratorDSL.g:1099:3: this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_ValuelDefinitionReferenceRule_0=ruleValuelDefinitionReferenceRule();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_InternalGeneratorDSL

    // Delegated rules

    public final boolean synpred17_InternalGeneratorDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalGeneratorDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String dfa_1s = "\31\uffff";
    static final String dfa_2s = "\1\23\1\4\1\24\1\uffff\24\24\1\uffff";
    static final String dfa_3s = "\1\23\1\62\1\137\1\uffff\24\37\1\uffff";
    static final String dfa_4s = "\3\uffff\1\2\24\uffff\1\1";
    static final String dfa_5s = "\31\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\2\3\1\2\2\3\12\uffff\1\3\23\uffff\1\3\6\uffff\2\3\1\uffff\2\3",
            "\1\3\3\uffff\1\3\6\uffff\1\30\54\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27",
            "",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            "\1\3\3\uffff\1\3\6\uffff\1\30",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "757:2: (this_CounterRangeRule_0= ruleCounterRangeRule | this_LiteralRangeRule_1= ruleLiteralRangeRule )";
        }
    }
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\2\uffff\2\6\5\uffff\2\6";
    static final String dfa_9s = "\1\4\1\uffff\2\20\3\uffff\1\7\1\uffff\2\20";
    static final String dfa_10s = "\1\62\1\uffff\2\113\3\uffff\1\10\1\uffff\2\113";
    static final String dfa_11s = "\1\uffff\1\1\2\uffff\1\3\1\4\1\5\1\uffff\1\2\2\uffff";
    static final String dfa_12s = "\13\uffff}>";
    static final String[] dfa_13s = {
            "\3\4\1\2\1\3\12\uffff\1\1\23\uffff\1\5\6\uffff\2\6\1\uffff\2\4",
            "",
            "\1\4\3\uffff\1\6\3\uffff\2\6\15\uffff\1\10\4\6\1\uffff\1\6\22\uffff\1\7\13\6",
            "\1\4\3\uffff\1\6\3\uffff\2\6\15\uffff\1\10\4\6\1\uffff\1\6\22\uffff\1\7\13\6",
            "",
            "",
            "",
            "\1\11\1\12",
            "",
            "\1\4\3\uffff\1\6\3\uffff\2\6\15\uffff\1\10\4\6\1\uffff\1\6\22\uffff\1\7\13\6",
            "\1\4\3\uffff\1\6\3\uffff\2\6\15\uffff\1\10\4\6\1\uffff\1\6\22\uffff\1\7\13\6"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1943:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x8000000000008000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000008040000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000340000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000004820000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000400000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004020000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000430000180L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0006C080000801F0L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00060000000001F0L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0006D180000801F0L,0x0000000000000180L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000010001000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0006D080000801F0L,0x0000000000000180L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000002L,0x000000000000007EL});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000E00L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0006C080000801F0L,0x0000000000000180L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0006C080001801F0L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000020180L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x00000000FFFFF000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0008000000000180L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x7FE0C00000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0001000002000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});

}