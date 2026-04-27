package de.evoal.languages.model.mll.dsl.parser.antlr.internal;

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
import de.evoal.languages.model.mll.dsl.services.MachineLearningLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalMachineLearningLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_DOUBLE", "RULE_INT", "RULE_QUOTED_ID", "RULE_ID", "RULE_DIGIT", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'{'", "'specify'", "'model'", "'gof'", "'use'", "'cases'", "';'", "'end'", "'}'", "'learning-task'", "'input'", "'features'", "','", "'output'", "'learning'", "'from'", "'['", "']'", "'testing'", "'with'", "'serialise'", "'to'", "'and'", "'validation'", "'steps'", "'preparation'", "'begin'", "'predicting'", "'pipeline'", "'step'", "'component'", "'reads'", "'writes'", "'for'", "'in'", "'increment'", "'by'", "'write'", "'samples'", "'executing'", "'('", "')'", "'OR'", "'XOR'", "'AND'", "'!'", "'^'", "'self'", "'value'", "'data'", "'instance'", "':='", "'true'", "'false'", "'@'", "':'", "'optional'", "'enum'", "'literal'", "'string'", "'expression'", "'int'", "'real'", "'boolean'", "'void'", "'array'", "'import'", "'.'", "'>='", "'>'", "'='", "'!='", "'<'", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'Y'", "'Z'", "'E'", "'P'", "'T'", "'G'", "'M'", "'k'", "'h'", "'da'", "'d'", "'c'", "'m'", "'\\u00B5'", "'n'", "'p'", "'f'", "'a'", "'z'", "'y'"
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
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
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
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalMachineLearningLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMachineLearningLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMachineLearningLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMachineLearningLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private MachineLearningLanguageGrammarAccess grammarAccess;

        public InternalMachineLearningLanguageParser(TokenStream input, MachineLearningLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "MachineLearningModuleRule";
       	}

       	@Override
       	protected MachineLearningLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleMachineLearningModuleRule"
    // InternalMachineLearningLanguage.g:72:1: entryRuleMachineLearningModuleRule returns [EObject current=null] : iv_ruleMachineLearningModuleRule= ruleMachineLearningModuleRule EOF ;
    public final EObject entryRuleMachineLearningModuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMachineLearningModuleRule = null;


        try {
            // InternalMachineLearningLanguage.g:72:66: (iv_ruleMachineLearningModuleRule= ruleMachineLearningModuleRule EOF )
            // InternalMachineLearningLanguage.g:73:2: iv_ruleMachineLearningModuleRule= ruleMachineLearningModuleRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMachineLearningModuleRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMachineLearningModuleRule=ruleMachineLearningModuleRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMachineLearningModuleRule; 
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
    // $ANTLR end "entryRuleMachineLearningModuleRule"


    // $ANTLR start "ruleMachineLearningModuleRule"
    // InternalMachineLearningLanguage.g:79:1: ruleMachineLearningModuleRule returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( (lv_task_4_0= ruleTaskDescriptionRule ) ) ( (lv_validation_5_0= ruleValidationPipelineDefinitionRule ) ) ( (lv_preparation_6_0= rulePreparationPipelineDefinitionRule ) ) otherlv_7= 'specify' otherlv_8= 'model' ( (lv_model_9_0= ruleInstanceLiteralRule ) ) (otherlv_10= 'specify' otherlv_11= 'gof' ( (lv_gof_12_0= ruleBodyRule ) ) )? (otherlv_13= 'use' otherlv_14= 'cases' ( ( (lv_learningUseCase_15_0= ruleLearningUseCaseRule ) ) otherlv_16= ';' )? ( ( (lv_predictionUseCase_17_0= rulePredictionUseCaseRule ) ) otherlv_18= ';' )? otherlv_19= 'end' )? otherlv_20= '}' ) ;
    public final EObject ruleMachineLearningModuleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        EObject lv_imports_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_task_4_0 = null;

        EObject lv_validation_5_0 = null;

        EObject lv_preparation_6_0 = null;

        EObject lv_model_9_0 = null;

        EObject lv_gof_12_0 = null;

        EObject lv_learningUseCase_15_0 = null;

        EObject lv_predictionUseCase_17_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:85:2: ( ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( (lv_task_4_0= ruleTaskDescriptionRule ) ) ( (lv_validation_5_0= ruleValidationPipelineDefinitionRule ) ) ( (lv_preparation_6_0= rulePreparationPipelineDefinitionRule ) ) otherlv_7= 'specify' otherlv_8= 'model' ( (lv_model_9_0= ruleInstanceLiteralRule ) ) (otherlv_10= 'specify' otherlv_11= 'gof' ( (lv_gof_12_0= ruleBodyRule ) ) )? (otherlv_13= 'use' otherlv_14= 'cases' ( ( (lv_learningUseCase_15_0= ruleLearningUseCaseRule ) ) otherlv_16= ';' )? ( ( (lv_predictionUseCase_17_0= rulePredictionUseCaseRule ) ) otherlv_18= ';' )? otherlv_19= 'end' )? otherlv_20= '}' ) )
            // InternalMachineLearningLanguage.g:86:2: ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( (lv_task_4_0= ruleTaskDescriptionRule ) ) ( (lv_validation_5_0= ruleValidationPipelineDefinitionRule ) ) ( (lv_preparation_6_0= rulePreparationPipelineDefinitionRule ) ) otherlv_7= 'specify' otherlv_8= 'model' ( (lv_model_9_0= ruleInstanceLiteralRule ) ) (otherlv_10= 'specify' otherlv_11= 'gof' ( (lv_gof_12_0= ruleBodyRule ) ) )? (otherlv_13= 'use' otherlv_14= 'cases' ( ( (lv_learningUseCase_15_0= ruleLearningUseCaseRule ) ) otherlv_16= ';' )? ( ( (lv_predictionUseCase_17_0= rulePredictionUseCaseRule ) ) otherlv_18= ';' )? otherlv_19= 'end' )? otherlv_20= '}' )
            {
            // InternalMachineLearningLanguage.g:86:2: ( ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( (lv_task_4_0= ruleTaskDescriptionRule ) ) ( (lv_validation_5_0= ruleValidationPipelineDefinitionRule ) ) ( (lv_preparation_6_0= rulePreparationPipelineDefinitionRule ) ) otherlv_7= 'specify' otherlv_8= 'model' ( (lv_model_9_0= ruleInstanceLiteralRule ) ) (otherlv_10= 'specify' otherlv_11= 'gof' ( (lv_gof_12_0= ruleBodyRule ) ) )? (otherlv_13= 'use' otherlv_14= 'cases' ( ( (lv_learningUseCase_15_0= ruleLearningUseCaseRule ) ) otherlv_16= ';' )? ( ( (lv_predictionUseCase_17_0= rulePredictionUseCaseRule ) ) otherlv_18= ';' )? otherlv_19= 'end' )? otherlv_20= '}' )
            // InternalMachineLearningLanguage.g:87:3: ( (lv_imports_0_0= ruleImportRule ) )* otherlv_1= 'module' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= '{' ( (lv_task_4_0= ruleTaskDescriptionRule ) ) ( (lv_validation_5_0= ruleValidationPipelineDefinitionRule ) ) ( (lv_preparation_6_0= rulePreparationPipelineDefinitionRule ) ) otherlv_7= 'specify' otherlv_8= 'model' ( (lv_model_9_0= ruleInstanceLiteralRule ) ) (otherlv_10= 'specify' otherlv_11= 'gof' ( (lv_gof_12_0= ruleBodyRule ) ) )? (otherlv_13= 'use' otherlv_14= 'cases' ( ( (lv_learningUseCase_15_0= ruleLearningUseCaseRule ) ) otherlv_16= ';' )? ( ( (lv_predictionUseCase_17_0= rulePredictionUseCaseRule ) ) otherlv_18= ';' )? otherlv_19= 'end' )? otherlv_20= '}'
            {
            // InternalMachineLearningLanguage.g:87:3: ( (lv_imports_0_0= ruleImportRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==82) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:88:4: (lv_imports_0_0= ruleImportRule )
            	    {
            	    // InternalMachineLearningLanguage.g:88:4: (lv_imports_0_0= ruleImportRule )
            	    // InternalMachineLearningLanguage.g:89:5: lv_imports_0_0= ruleImportRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMachineLearningModuleRuleAccess().getImportsImportRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImportRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMachineLearningModuleRuleRule());
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

              			newLeafNode(otherlv_1, grammarAccess.getMachineLearningModuleRuleAccess().getModuleKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:110:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:111:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:111:4: (lv_name_2_0= ruleQualifiedName )
            // InternalMachineLearningLanguage.g:112:5: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMachineLearningModuleRuleAccess().getNameQualifiedNameParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMachineLearningModuleRuleRule());
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

              			newLeafNode(otherlv_3, grammarAccess.getMachineLearningModuleRuleAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalMachineLearningLanguage.g:133:3: ( (lv_task_4_0= ruleTaskDescriptionRule ) )
            // InternalMachineLearningLanguage.g:134:4: (lv_task_4_0= ruleTaskDescriptionRule )
            {
            // InternalMachineLearningLanguage.g:134:4: (lv_task_4_0= ruleTaskDescriptionRule )
            // InternalMachineLearningLanguage.g:135:5: lv_task_4_0= ruleTaskDescriptionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMachineLearningModuleRuleAccess().getTaskTaskDescriptionRuleParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_task_4_0=ruleTaskDescriptionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMachineLearningModuleRuleRule());
              					}
              					set(
              						current,
              						"task",
              						lv_task_4_0,
              						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.TaskDescriptionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:152:3: ( (lv_validation_5_0= ruleValidationPipelineDefinitionRule ) )
            // InternalMachineLearningLanguage.g:153:4: (lv_validation_5_0= ruleValidationPipelineDefinitionRule )
            {
            // InternalMachineLearningLanguage.g:153:4: (lv_validation_5_0= ruleValidationPipelineDefinitionRule )
            // InternalMachineLearningLanguage.g:154:5: lv_validation_5_0= ruleValidationPipelineDefinitionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMachineLearningModuleRuleAccess().getValidationValidationPipelineDefinitionRuleParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_validation_5_0=ruleValidationPipelineDefinitionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMachineLearningModuleRuleRule());
              					}
              					set(
              						current,
              						"validation",
              						lv_validation_5_0,
              						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.ValidationPipelineDefinitionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:171:3: ( (lv_preparation_6_0= rulePreparationPipelineDefinitionRule ) )
            // InternalMachineLearningLanguage.g:172:4: (lv_preparation_6_0= rulePreparationPipelineDefinitionRule )
            {
            // InternalMachineLearningLanguage.g:172:4: (lv_preparation_6_0= rulePreparationPipelineDefinitionRule )
            // InternalMachineLearningLanguage.g:173:5: lv_preparation_6_0= rulePreparationPipelineDefinitionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMachineLearningModuleRuleAccess().getPreparationPreparationPipelineDefinitionRuleParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_preparation_6_0=rulePreparationPipelineDefinitionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMachineLearningModuleRuleRule());
              					}
              					set(
              						current,
              						"preparation",
              						lv_preparation_6_0,
              						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.PreparationPipelineDefinitionRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getMachineLearningModuleRuleAccess().getSpecifyKeyword_7());
              		
            }
            otherlv_8=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getMachineLearningModuleRuleAccess().getModelKeyword_8());
              		
            }
            // InternalMachineLearningLanguage.g:198:3: ( (lv_model_9_0= ruleInstanceLiteralRule ) )
            // InternalMachineLearningLanguage.g:199:4: (lv_model_9_0= ruleInstanceLiteralRule )
            {
            // InternalMachineLearningLanguage.g:199:4: (lv_model_9_0= ruleInstanceLiteralRule )
            // InternalMachineLearningLanguage.g:200:5: lv_model_9_0= ruleInstanceLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMachineLearningModuleRuleAccess().getModelInstanceLiteralRuleParserRuleCall_9_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_model_9_0=ruleInstanceLiteralRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMachineLearningModuleRuleRule());
              					}
              					set(
              						current,
              						"model",
              						lv_model_9_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.InstanceLiteralRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:217:3: (otherlv_10= 'specify' otherlv_11= 'gof' ( (lv_gof_12_0= ruleBodyRule ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalMachineLearningLanguage.g:218:4: otherlv_10= 'specify' otherlv_11= 'gof' ( (lv_gof_12_0= ruleBodyRule ) )
                    {
                    otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getMachineLearningModuleRuleAccess().getSpecifyKeyword_10_0());
                      			
                    }
                    otherlv_11=(Token)match(input,19,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getMachineLearningModuleRuleAccess().getGofKeyword_10_1());
                      			
                    }
                    // InternalMachineLearningLanguage.g:226:4: ( (lv_gof_12_0= ruleBodyRule ) )
                    // InternalMachineLearningLanguage.g:227:5: (lv_gof_12_0= ruleBodyRule )
                    {
                    // InternalMachineLearningLanguage.g:227:5: (lv_gof_12_0= ruleBodyRule )
                    // InternalMachineLearningLanguage.g:228:6: lv_gof_12_0= ruleBodyRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getMachineLearningModuleRuleAccess().getGofBodyRuleParserRuleCall_10_2_0());
                      					
                    }
                    pushFollow(FOLLOW_11);
                    lv_gof_12_0=ruleBodyRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getMachineLearningModuleRuleRule());
                      						}
                      						set(
                      							current,
                      							"gof",
                      							lv_gof_12_0,
                      							"de.evoal.languages.model.generator.dsl.GeneratorDSL.BodyRule");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalMachineLearningLanguage.g:246:3: (otherlv_13= 'use' otherlv_14= 'cases' ( ( (lv_learningUseCase_15_0= ruleLearningUseCaseRule ) ) otherlv_16= ';' )? ( ( (lv_predictionUseCase_17_0= rulePredictionUseCaseRule ) ) otherlv_18= ';' )? otherlv_19= 'end' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==20) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalMachineLearningLanguage.g:247:4: otherlv_13= 'use' otherlv_14= 'cases' ( ( (lv_learningUseCase_15_0= ruleLearningUseCaseRule ) ) otherlv_16= ';' )? ( ( (lv_predictionUseCase_17_0= rulePredictionUseCaseRule ) ) otherlv_18= ';' )? otherlv_19= 'end'
                    {
                    otherlv_13=(Token)match(input,20,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getMachineLearningModuleRuleAccess().getUseKeyword_11_0());
                      			
                    }
                    otherlv_14=(Token)match(input,21,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getMachineLearningModuleRuleAccess().getCasesKeyword_11_1());
                      			
                    }
                    // InternalMachineLearningLanguage.g:255:4: ( ( (lv_learningUseCase_15_0= ruleLearningUseCaseRule ) ) otherlv_16= ';' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==17) ) {
                        int LA3_1 = input.LA(2);

                        if ( (LA3_1==30) ) {
                            alt3=1;
                        }
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalMachineLearningLanguage.g:256:5: ( (lv_learningUseCase_15_0= ruleLearningUseCaseRule ) ) otherlv_16= ';'
                            {
                            // InternalMachineLearningLanguage.g:256:5: ( (lv_learningUseCase_15_0= ruleLearningUseCaseRule ) )
                            // InternalMachineLearningLanguage.g:257:6: (lv_learningUseCase_15_0= ruleLearningUseCaseRule )
                            {
                            // InternalMachineLearningLanguage.g:257:6: (lv_learningUseCase_15_0= ruleLearningUseCaseRule )
                            // InternalMachineLearningLanguage.g:258:7: lv_learningUseCase_15_0= ruleLearningUseCaseRule
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getMachineLearningModuleRuleAccess().getLearningUseCaseLearningUseCaseRuleParserRuleCall_11_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_14);
                            lv_learningUseCase_15_0=ruleLearningUseCaseRule();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getMachineLearningModuleRuleRule());
                              							}
                              							set(
                              								current,
                              								"learningUseCase",
                              								lv_learningUseCase_15_0,
                              								"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.LearningUseCaseRule");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            otherlv_16=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_16, grammarAccess.getMachineLearningModuleRuleAccess().getSemicolonKeyword_11_2_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalMachineLearningLanguage.g:280:4: ( ( (lv_predictionUseCase_17_0= rulePredictionUseCaseRule ) ) otherlv_18= ';' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==17) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalMachineLearningLanguage.g:281:5: ( (lv_predictionUseCase_17_0= rulePredictionUseCaseRule ) ) otherlv_18= ';'
                            {
                            // InternalMachineLearningLanguage.g:281:5: ( (lv_predictionUseCase_17_0= rulePredictionUseCaseRule ) )
                            // InternalMachineLearningLanguage.g:282:6: (lv_predictionUseCase_17_0= rulePredictionUseCaseRule )
                            {
                            // InternalMachineLearningLanguage.g:282:6: (lv_predictionUseCase_17_0= rulePredictionUseCaseRule )
                            // InternalMachineLearningLanguage.g:283:7: lv_predictionUseCase_17_0= rulePredictionUseCaseRule
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getMachineLearningModuleRuleAccess().getPredictionUseCasePredictionUseCaseRuleParserRuleCall_11_3_0_0());
                              						
                            }
                            pushFollow(FOLLOW_14);
                            lv_predictionUseCase_17_0=rulePredictionUseCaseRule();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getMachineLearningModuleRuleRule());
                              							}
                              							set(
                              								current,
                              								"predictionUseCase",
                              								lv_predictionUseCase_17_0,
                              								"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.PredictionUseCaseRule");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            otherlv_18=(Token)match(input,22,FOLLOW_15); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_18, grammarAccess.getMachineLearningModuleRuleAccess().getSemicolonKeyword_11_3_1());
                              				
                            }

                            }
                            break;

                    }

                    otherlv_19=(Token)match(input,23,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_19, grammarAccess.getMachineLearningModuleRuleAccess().getEndKeyword_11_4());
                      			
                    }

                    }
                    break;

            }

            otherlv_20=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_20, grammarAccess.getMachineLearningModuleRuleAccess().getRightCurlyBracketKeyword_12());
              		
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
    // $ANTLR end "ruleMachineLearningModuleRule"


    // $ANTLR start "entryRuleTaskDescriptionRule"
    // InternalMachineLearningLanguage.g:318:1: entryRuleTaskDescriptionRule returns [EObject current=null] : iv_ruleTaskDescriptionRule= ruleTaskDescriptionRule EOF ;
    public final EObject entryRuleTaskDescriptionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTaskDescriptionRule = null;


        try {
            // InternalMachineLearningLanguage.g:318:60: (iv_ruleTaskDescriptionRule= ruleTaskDescriptionRule EOF )
            // InternalMachineLearningLanguage.g:319:2: iv_ruleTaskDescriptionRule= ruleTaskDescriptionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTaskDescriptionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTaskDescriptionRule=ruleTaskDescriptionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTaskDescriptionRule; 
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
    // $ANTLR end "entryRuleTaskDescriptionRule"


    // $ANTLR start "ruleTaskDescriptionRule"
    // InternalMachineLearningLanguage.g:325:1: ruleTaskDescriptionRule returns [EObject current=null] : (otherlv_0= 'specify' ( (lv_name_1_0= 'learning-task' ) ) otherlv_2= '{' otherlv_3= 'input' otherlv_4= 'features' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* otherlv_8= 'output' otherlv_9= 'features' ( ( ruleQualifiedName ) ) (otherlv_11= ',' ( ( ruleQualifiedName ) ) )* otherlv_13= 'learning' otherlv_14= 'from' otherlv_15= '[' ( (lv_learningData_16_0= RULE_STRING ) ) (otherlv_17= ',' ( (lv_learningData_18_0= RULE_STRING ) ) )* otherlv_19= ']' (otherlv_20= 'testing' otherlv_21= 'with' otherlv_22= '[' ( (lv_testingData_23_0= RULE_STRING ) ) (otherlv_24= ',' ( (lv_testingData_25_0= RULE_STRING ) ) )* otherlv_26= ']' )? otherlv_27= 'serialise' otherlv_28= 'to' ( (lv_modelFile_29_0= RULE_STRING ) ) (otherlv_30= 'and' ( (lv_gofFile_31_0= RULE_STRING ) ) )? otherlv_32= '}' ) ;
    public final EObject ruleTaskDescriptionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token lv_learningData_16_0=null;
        Token otherlv_17=null;
        Token lv_learningData_18_0=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token lv_testingData_23_0=null;
        Token otherlv_24=null;
        Token lv_testingData_25_0=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token lv_modelFile_29_0=null;
        Token otherlv_30=null;
        Token lv_gofFile_31_0=null;
        Token otherlv_32=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:331:2: ( (otherlv_0= 'specify' ( (lv_name_1_0= 'learning-task' ) ) otherlv_2= '{' otherlv_3= 'input' otherlv_4= 'features' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* otherlv_8= 'output' otherlv_9= 'features' ( ( ruleQualifiedName ) ) (otherlv_11= ',' ( ( ruleQualifiedName ) ) )* otherlv_13= 'learning' otherlv_14= 'from' otherlv_15= '[' ( (lv_learningData_16_0= RULE_STRING ) ) (otherlv_17= ',' ( (lv_learningData_18_0= RULE_STRING ) ) )* otherlv_19= ']' (otherlv_20= 'testing' otherlv_21= 'with' otherlv_22= '[' ( (lv_testingData_23_0= RULE_STRING ) ) (otherlv_24= ',' ( (lv_testingData_25_0= RULE_STRING ) ) )* otherlv_26= ']' )? otherlv_27= 'serialise' otherlv_28= 'to' ( (lv_modelFile_29_0= RULE_STRING ) ) (otherlv_30= 'and' ( (lv_gofFile_31_0= RULE_STRING ) ) )? otherlv_32= '}' ) )
            // InternalMachineLearningLanguage.g:332:2: (otherlv_0= 'specify' ( (lv_name_1_0= 'learning-task' ) ) otherlv_2= '{' otherlv_3= 'input' otherlv_4= 'features' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* otherlv_8= 'output' otherlv_9= 'features' ( ( ruleQualifiedName ) ) (otherlv_11= ',' ( ( ruleQualifiedName ) ) )* otherlv_13= 'learning' otherlv_14= 'from' otherlv_15= '[' ( (lv_learningData_16_0= RULE_STRING ) ) (otherlv_17= ',' ( (lv_learningData_18_0= RULE_STRING ) ) )* otherlv_19= ']' (otherlv_20= 'testing' otherlv_21= 'with' otherlv_22= '[' ( (lv_testingData_23_0= RULE_STRING ) ) (otherlv_24= ',' ( (lv_testingData_25_0= RULE_STRING ) ) )* otherlv_26= ']' )? otherlv_27= 'serialise' otherlv_28= 'to' ( (lv_modelFile_29_0= RULE_STRING ) ) (otherlv_30= 'and' ( (lv_gofFile_31_0= RULE_STRING ) ) )? otherlv_32= '}' )
            {
            // InternalMachineLearningLanguage.g:332:2: (otherlv_0= 'specify' ( (lv_name_1_0= 'learning-task' ) ) otherlv_2= '{' otherlv_3= 'input' otherlv_4= 'features' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* otherlv_8= 'output' otherlv_9= 'features' ( ( ruleQualifiedName ) ) (otherlv_11= ',' ( ( ruleQualifiedName ) ) )* otherlv_13= 'learning' otherlv_14= 'from' otherlv_15= '[' ( (lv_learningData_16_0= RULE_STRING ) ) (otherlv_17= ',' ( (lv_learningData_18_0= RULE_STRING ) ) )* otherlv_19= ']' (otherlv_20= 'testing' otherlv_21= 'with' otherlv_22= '[' ( (lv_testingData_23_0= RULE_STRING ) ) (otherlv_24= ',' ( (lv_testingData_25_0= RULE_STRING ) ) )* otherlv_26= ']' )? otherlv_27= 'serialise' otherlv_28= 'to' ( (lv_modelFile_29_0= RULE_STRING ) ) (otherlv_30= 'and' ( (lv_gofFile_31_0= RULE_STRING ) ) )? otherlv_32= '}' )
            // InternalMachineLearningLanguage.g:333:3: otherlv_0= 'specify' ( (lv_name_1_0= 'learning-task' ) ) otherlv_2= '{' otherlv_3= 'input' otherlv_4= 'features' ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* otherlv_8= 'output' otherlv_9= 'features' ( ( ruleQualifiedName ) ) (otherlv_11= ',' ( ( ruleQualifiedName ) ) )* otherlv_13= 'learning' otherlv_14= 'from' otherlv_15= '[' ( (lv_learningData_16_0= RULE_STRING ) ) (otherlv_17= ',' ( (lv_learningData_18_0= RULE_STRING ) ) )* otherlv_19= ']' (otherlv_20= 'testing' otherlv_21= 'with' otherlv_22= '[' ( (lv_testingData_23_0= RULE_STRING ) ) (otherlv_24= ',' ( (lv_testingData_25_0= RULE_STRING ) ) )* otherlv_26= ']' )? otherlv_27= 'serialise' otherlv_28= 'to' ( (lv_modelFile_29_0= RULE_STRING ) ) (otherlv_30= 'and' ( (lv_gofFile_31_0= RULE_STRING ) ) )? otherlv_32= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTaskDescriptionRuleAccess().getSpecifyKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:337:3: ( (lv_name_1_0= 'learning-task' ) )
            // InternalMachineLearningLanguage.g:338:4: (lv_name_1_0= 'learning-task' )
            {
            // InternalMachineLearningLanguage.g:338:4: (lv_name_1_0= 'learning-task' )
            // InternalMachineLearningLanguage.g:339:5: lv_name_1_0= 'learning-task'
            {
            lv_name_1_0=(Token)match(input,25,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getTaskDescriptionRuleAccess().getNameLearningTaskKeyword_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTaskDescriptionRuleRule());
              					}
              					setWithLastConsumed(current, "name", lv_name_1_0, "learning-task");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getTaskDescriptionRuleAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,26,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getTaskDescriptionRuleAccess().getInputKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,27,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getTaskDescriptionRuleAccess().getFeaturesKeyword_4());
              		
            }
            // InternalMachineLearningLanguage.g:363:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:364:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:364:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:365:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTaskDescriptionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTaskDescriptionRuleAccess().getInputsDataDescriptionCrossReference_5_0());
              				
            }
            pushFollow(FOLLOW_20);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:382:3: (otherlv_6= ',' ( ( ruleQualifiedName ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==28) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:383:4: otherlv_6= ',' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_6=(Token)match(input,28,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_6, grammarAccess.getTaskDescriptionRuleAccess().getCommaKeyword_6_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:387:4: ( ( ruleQualifiedName ) )
            	    // InternalMachineLearningLanguage.g:388:5: ( ruleQualifiedName )
            	    {
            	    // InternalMachineLearningLanguage.g:388:5: ( ruleQualifiedName )
            	    // InternalMachineLearningLanguage.g:389:6: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getTaskDescriptionRuleRule());
            	      						}
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTaskDescriptionRuleAccess().getInputsDataDescriptionCrossReference_6_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
            	    ruleQualifiedName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_8=(Token)match(input,29,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getTaskDescriptionRuleAccess().getOutputKeyword_7());
              		
            }
            otherlv_9=(Token)match(input,27,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getTaskDescriptionRuleAccess().getFeaturesKeyword_8());
              		
            }
            // InternalMachineLearningLanguage.g:415:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:416:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:416:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:417:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTaskDescriptionRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTaskDescriptionRuleAccess().getOutputsDataDescriptionCrossReference_9_0());
              				
            }
            pushFollow(FOLLOW_21);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:434:3: (otherlv_11= ',' ( ( ruleQualifiedName ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==28) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:435:4: otherlv_11= ',' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_11=(Token)match(input,28,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_11, grammarAccess.getTaskDescriptionRuleAccess().getCommaKeyword_10_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:439:4: ( ( ruleQualifiedName ) )
            	    // InternalMachineLearningLanguage.g:440:5: ( ruleQualifiedName )
            	    {
            	    // InternalMachineLearningLanguage.g:440:5: ( ruleQualifiedName )
            	    // InternalMachineLearningLanguage.g:441:6: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getTaskDescriptionRuleRule());
            	      						}
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTaskDescriptionRuleAccess().getOutputsDataDescriptionCrossReference_10_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_21);
            	    ruleQualifiedName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_13=(Token)match(input,30,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_13, grammarAccess.getTaskDescriptionRuleAccess().getLearningKeyword_11());
              		
            }
            otherlv_14=(Token)match(input,31,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_14, grammarAccess.getTaskDescriptionRuleAccess().getFromKeyword_12());
              		
            }
            otherlv_15=(Token)match(input,32,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_15, grammarAccess.getTaskDescriptionRuleAccess().getLeftSquareBracketKeyword_13());
              		
            }
            // InternalMachineLearningLanguage.g:471:3: ( (lv_learningData_16_0= RULE_STRING ) )
            // InternalMachineLearningLanguage.g:472:4: (lv_learningData_16_0= RULE_STRING )
            {
            // InternalMachineLearningLanguage.g:472:4: (lv_learningData_16_0= RULE_STRING )
            // InternalMachineLearningLanguage.g:473:5: lv_learningData_16_0= RULE_STRING
            {
            lv_learningData_16_0=(Token)match(input,RULE_STRING,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_learningData_16_0, grammarAccess.getTaskDescriptionRuleAccess().getLearningDataSTRINGTerminalRuleCall_14_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTaskDescriptionRuleRule());
              					}
              					addWithLastConsumed(
              						current,
              						"learningData",
              						lv_learningData_16_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:489:3: (otherlv_17= ',' ( (lv_learningData_18_0= RULE_STRING ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==28) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:490:4: otherlv_17= ',' ( (lv_learningData_18_0= RULE_STRING ) )
            	    {
            	    otherlv_17=(Token)match(input,28,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_17, grammarAccess.getTaskDescriptionRuleAccess().getCommaKeyword_15_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:494:4: ( (lv_learningData_18_0= RULE_STRING ) )
            	    // InternalMachineLearningLanguage.g:495:5: (lv_learningData_18_0= RULE_STRING )
            	    {
            	    // InternalMachineLearningLanguage.g:495:5: (lv_learningData_18_0= RULE_STRING )
            	    // InternalMachineLearningLanguage.g:496:6: lv_learningData_18_0= RULE_STRING
            	    {
            	    lv_learningData_18_0=(Token)match(input,RULE_STRING,FOLLOW_25); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_learningData_18_0, grammarAccess.getTaskDescriptionRuleAccess().getLearningDataSTRINGTerminalRuleCall_15_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getTaskDescriptionRuleRule());
            	      						}
            	      						addWithLastConsumed(
            	      							current,
            	      							"learningData",
            	      							lv_learningData_18_0,
            	      							"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_19=(Token)match(input,33,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_19, grammarAccess.getTaskDescriptionRuleAccess().getRightSquareBracketKeyword_16());
              		
            }
            // InternalMachineLearningLanguage.g:517:3: (otherlv_20= 'testing' otherlv_21= 'with' otherlv_22= '[' ( (lv_testingData_23_0= RULE_STRING ) ) (otherlv_24= ',' ( (lv_testingData_25_0= RULE_STRING ) ) )* otherlv_26= ']' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==34) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMachineLearningLanguage.g:518:4: otherlv_20= 'testing' otherlv_21= 'with' otherlv_22= '[' ( (lv_testingData_23_0= RULE_STRING ) ) (otherlv_24= ',' ( (lv_testingData_25_0= RULE_STRING ) ) )* otherlv_26= ']'
                    {
                    otherlv_20=(Token)match(input,34,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_20, grammarAccess.getTaskDescriptionRuleAccess().getTestingKeyword_17_0());
                      			
                    }
                    otherlv_21=(Token)match(input,35,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_21, grammarAccess.getTaskDescriptionRuleAccess().getWithKeyword_17_1());
                      			
                    }
                    otherlv_22=(Token)match(input,32,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_22, grammarAccess.getTaskDescriptionRuleAccess().getLeftSquareBracketKeyword_17_2());
                      			
                    }
                    // InternalMachineLearningLanguage.g:530:4: ( (lv_testingData_23_0= RULE_STRING ) )
                    // InternalMachineLearningLanguage.g:531:5: (lv_testingData_23_0= RULE_STRING )
                    {
                    // InternalMachineLearningLanguage.g:531:5: (lv_testingData_23_0= RULE_STRING )
                    // InternalMachineLearningLanguage.g:532:6: lv_testingData_23_0= RULE_STRING
                    {
                    lv_testingData_23_0=(Token)match(input,RULE_STRING,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_testingData_23_0, grammarAccess.getTaskDescriptionRuleAccess().getTestingDataSTRINGTerminalRuleCall_17_3_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTaskDescriptionRuleRule());
                      						}
                      						addWithLastConsumed(
                      							current,
                      							"testingData",
                      							lv_testingData_23_0,
                      							"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
                      					
                    }

                    }


                    }

                    // InternalMachineLearningLanguage.g:548:4: (otherlv_24= ',' ( (lv_testingData_25_0= RULE_STRING ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==28) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalMachineLearningLanguage.g:549:5: otherlv_24= ',' ( (lv_testingData_25_0= RULE_STRING ) )
                    	    {
                    	    otherlv_24=(Token)match(input,28,FOLLOW_24); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_24, grammarAccess.getTaskDescriptionRuleAccess().getCommaKeyword_17_4_0());
                    	      				
                    	    }
                    	    // InternalMachineLearningLanguage.g:553:5: ( (lv_testingData_25_0= RULE_STRING ) )
                    	    // InternalMachineLearningLanguage.g:554:6: (lv_testingData_25_0= RULE_STRING )
                    	    {
                    	    // InternalMachineLearningLanguage.g:554:6: (lv_testingData_25_0= RULE_STRING )
                    	    // InternalMachineLearningLanguage.g:555:7: lv_testingData_25_0= RULE_STRING
                    	    {
                    	    lv_testingData_25_0=(Token)match(input,RULE_STRING,FOLLOW_25); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(lv_testingData_25_0, grammarAccess.getTaskDescriptionRuleAccess().getTestingDataSTRINGTerminalRuleCall_17_4_1_0());
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getTaskDescriptionRuleRule());
                    	      							}
                    	      							addWithLastConsumed(
                    	      								current,
                    	      								"testingData",
                    	      								lv_testingData_25_0,
                    	      								"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,33,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_26, grammarAccess.getTaskDescriptionRuleAccess().getRightSquareBracketKeyword_17_5());
                      			
                    }

                    }
                    break;

            }

            otherlv_27=(Token)match(input,36,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_27, grammarAccess.getTaskDescriptionRuleAccess().getSerialiseKeyword_18());
              		
            }
            otherlv_28=(Token)match(input,37,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_28, grammarAccess.getTaskDescriptionRuleAccess().getToKeyword_19());
              		
            }
            // InternalMachineLearningLanguage.g:585:3: ( (lv_modelFile_29_0= RULE_STRING ) )
            // InternalMachineLearningLanguage.g:586:4: (lv_modelFile_29_0= RULE_STRING )
            {
            // InternalMachineLearningLanguage.g:586:4: (lv_modelFile_29_0= RULE_STRING )
            // InternalMachineLearningLanguage.g:587:5: lv_modelFile_29_0= RULE_STRING
            {
            lv_modelFile_29_0=(Token)match(input,RULE_STRING,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_modelFile_29_0, grammarAccess.getTaskDescriptionRuleAccess().getModelFileSTRINGTerminalRuleCall_20_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTaskDescriptionRuleRule());
              					}
              					setWithLastConsumed(
              						current,
              						"modelFile",
              						lv_modelFile_29_0,
              						"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
              				
            }

            }


            }

            // InternalMachineLearningLanguage.g:603:3: (otherlv_30= 'and' ( (lv_gofFile_31_0= RULE_STRING ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==38) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMachineLearningLanguage.g:604:4: otherlv_30= 'and' ( (lv_gofFile_31_0= RULE_STRING ) )
                    {
                    otherlv_30=(Token)match(input,38,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_30, grammarAccess.getTaskDescriptionRuleAccess().getAndKeyword_21_0());
                      			
                    }
                    // InternalMachineLearningLanguage.g:608:4: ( (lv_gofFile_31_0= RULE_STRING ) )
                    // InternalMachineLearningLanguage.g:609:5: (lv_gofFile_31_0= RULE_STRING )
                    {
                    // InternalMachineLearningLanguage.g:609:5: (lv_gofFile_31_0= RULE_STRING )
                    // InternalMachineLearningLanguage.g:610:6: lv_gofFile_31_0= RULE_STRING
                    {
                    lv_gofFile_31_0=(Token)match(input,RULE_STRING,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_gofFile_31_0, grammarAccess.getTaskDescriptionRuleAccess().getGofFileSTRINGTerminalRuleCall_21_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTaskDescriptionRuleRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"gofFile",
                      							lv_gofFile_31_0,
                      							"de.evoal.languages.model.base.dsl.BaseLanguage.STRING");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_32=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_32, grammarAccess.getTaskDescriptionRuleAccess().getRightCurlyBracketKeyword_22());
              		
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
    // $ANTLR end "ruleTaskDescriptionRule"


    // $ANTLR start "entryRuleValidationPipelineDefinitionRule"
    // InternalMachineLearningLanguage.g:635:1: entryRuleValidationPipelineDefinitionRule returns [EObject current=null] : iv_ruleValidationPipelineDefinitionRule= ruleValidationPipelineDefinitionRule EOF ;
    public final EObject entryRuleValidationPipelineDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValidationPipelineDefinitionRule = null;


        try {
            // InternalMachineLearningLanguage.g:635:73: (iv_ruleValidationPipelineDefinitionRule= ruleValidationPipelineDefinitionRule EOF )
            // InternalMachineLearningLanguage.g:636:2: iv_ruleValidationPipelineDefinitionRule= ruleValidationPipelineDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidationPipelineDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValidationPipelineDefinitionRule=ruleValidationPipelineDefinitionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidationPipelineDefinitionRule; 
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
    // $ANTLR end "entryRuleValidationPipelineDefinitionRule"


    // $ANTLR start "ruleValidationPipelineDefinitionRule"
    // InternalMachineLearningLanguage.g:642:1: ruleValidationPipelineDefinitionRule returns [EObject current=null] : ( () otherlv_1= 'specify' ( (lv_name_2_0= 'validation' ) ) otherlv_3= 'steps' otherlv_4= '[' ( (lv_steps_5_0= ruleStepRule ) )* otherlv_6= ']' ) ;
    public final EObject ruleValidationPipelineDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_steps_5_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:648:2: ( ( () otherlv_1= 'specify' ( (lv_name_2_0= 'validation' ) ) otherlv_3= 'steps' otherlv_4= '[' ( (lv_steps_5_0= ruleStepRule ) )* otherlv_6= ']' ) )
            // InternalMachineLearningLanguage.g:649:2: ( () otherlv_1= 'specify' ( (lv_name_2_0= 'validation' ) ) otherlv_3= 'steps' otherlv_4= '[' ( (lv_steps_5_0= ruleStepRule ) )* otherlv_6= ']' )
            {
            // InternalMachineLearningLanguage.g:649:2: ( () otherlv_1= 'specify' ( (lv_name_2_0= 'validation' ) ) otherlv_3= 'steps' otherlv_4= '[' ( (lv_steps_5_0= ruleStepRule ) )* otherlv_6= ']' )
            // InternalMachineLearningLanguage.g:650:3: () otherlv_1= 'specify' ( (lv_name_2_0= 'validation' ) ) otherlv_3= 'steps' otherlv_4= '[' ( (lv_steps_5_0= ruleStepRule ) )* otherlv_6= ']'
            {
            // InternalMachineLearningLanguage.g:650:3: ()
            // InternalMachineLearningLanguage.g:651:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getValidationPipelineDefinitionRuleAccess().getPipelineDefinitionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,17,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getValidationPipelineDefinitionRuleAccess().getSpecifyKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:664:3: ( (lv_name_2_0= 'validation' ) )
            // InternalMachineLearningLanguage.g:665:4: (lv_name_2_0= 'validation' )
            {
            // InternalMachineLearningLanguage.g:665:4: (lv_name_2_0= 'validation' )
            // InternalMachineLearningLanguage.g:666:5: lv_name_2_0= 'validation'
            {
            lv_name_2_0=(Token)match(input,39,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getValidationPipelineDefinitionRuleAccess().getNameValidationKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getValidationPipelineDefinitionRuleRule());
              					}
              					setWithLastConsumed(current, "name", lv_name_2_0, "validation");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,40,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getValidationPipelineDefinitionRuleAccess().getStepsKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,32,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getValidationPipelineDefinitionRuleAccess().getLeftSquareBracketKeyword_4());
              		
            }
            // InternalMachineLearningLanguage.g:686:3: ( (lv_steps_5_0= ruleStepRule ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=44 && LA12_0<=45)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:687:4: (lv_steps_5_0= ruleStepRule )
            	    {
            	    // InternalMachineLearningLanguage.g:687:4: (lv_steps_5_0= ruleStepRule )
            	    // InternalMachineLearningLanguage.g:688:5: lv_steps_5_0= ruleStepRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getValidationPipelineDefinitionRuleAccess().getStepsStepRuleParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_33);
            	    lv_steps_5_0=ruleStepRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getValidationPipelineDefinitionRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"steps",
            	      						lv_steps_5_0,
            	      						"de.evoal.languages.model.generator.dsl.GeneratorDSL.StepRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_6=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getValidationPipelineDefinitionRuleAccess().getRightSquareBracketKeyword_6());
              		
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
    // $ANTLR end "ruleValidationPipelineDefinitionRule"


    // $ANTLR start "entryRulePreparationPipelineDefinitionRule"
    // InternalMachineLearningLanguage.g:713:1: entryRulePreparationPipelineDefinitionRule returns [EObject current=null] : iv_rulePreparationPipelineDefinitionRule= rulePreparationPipelineDefinitionRule EOF ;
    public final EObject entryRulePreparationPipelineDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreparationPipelineDefinitionRule = null;


        try {
            // InternalMachineLearningLanguage.g:713:74: (iv_rulePreparationPipelineDefinitionRule= rulePreparationPipelineDefinitionRule EOF )
            // InternalMachineLearningLanguage.g:714:2: iv_rulePreparationPipelineDefinitionRule= rulePreparationPipelineDefinitionRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPreparationPipelineDefinitionRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePreparationPipelineDefinitionRule=rulePreparationPipelineDefinitionRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePreparationPipelineDefinitionRule; 
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
    // $ANTLR end "entryRulePreparationPipelineDefinitionRule"


    // $ANTLR start "rulePreparationPipelineDefinitionRule"
    // InternalMachineLearningLanguage.g:720:1: rulePreparationPipelineDefinitionRule returns [EObject current=null] : ( () otherlv_1= 'specify' ( (lv_name_2_0= 'preparation' ) ) otherlv_3= 'steps' otherlv_4= '[' ( (lv_steps_5_0= ruleStepRule ) )* otherlv_6= ']' ) ;
    public final EObject rulePreparationPipelineDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_steps_5_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:726:2: ( ( () otherlv_1= 'specify' ( (lv_name_2_0= 'preparation' ) ) otherlv_3= 'steps' otherlv_4= '[' ( (lv_steps_5_0= ruleStepRule ) )* otherlv_6= ']' ) )
            // InternalMachineLearningLanguage.g:727:2: ( () otherlv_1= 'specify' ( (lv_name_2_0= 'preparation' ) ) otherlv_3= 'steps' otherlv_4= '[' ( (lv_steps_5_0= ruleStepRule ) )* otherlv_6= ']' )
            {
            // InternalMachineLearningLanguage.g:727:2: ( () otherlv_1= 'specify' ( (lv_name_2_0= 'preparation' ) ) otherlv_3= 'steps' otherlv_4= '[' ( (lv_steps_5_0= ruleStepRule ) )* otherlv_6= ']' )
            // InternalMachineLearningLanguage.g:728:3: () otherlv_1= 'specify' ( (lv_name_2_0= 'preparation' ) ) otherlv_3= 'steps' otherlv_4= '[' ( (lv_steps_5_0= ruleStepRule ) )* otherlv_6= ']'
            {
            // InternalMachineLearningLanguage.g:728:3: ()
            // InternalMachineLearningLanguage.g:729:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPreparationPipelineDefinitionRuleAccess().getPipelineDefinitionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,17,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPreparationPipelineDefinitionRuleAccess().getSpecifyKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:742:3: ( (lv_name_2_0= 'preparation' ) )
            // InternalMachineLearningLanguage.g:743:4: (lv_name_2_0= 'preparation' )
            {
            // InternalMachineLearningLanguage.g:743:4: (lv_name_2_0= 'preparation' )
            // InternalMachineLearningLanguage.g:744:5: lv_name_2_0= 'preparation'
            {
            lv_name_2_0=(Token)match(input,41,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getPreparationPipelineDefinitionRuleAccess().getNamePreparationKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPreparationPipelineDefinitionRuleRule());
              					}
              					setWithLastConsumed(current, "name", lv_name_2_0, "preparation");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,40,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getPreparationPipelineDefinitionRuleAccess().getStepsKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,32,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getPreparationPipelineDefinitionRuleAccess().getLeftSquareBracketKeyword_4());
              		
            }
            // InternalMachineLearningLanguage.g:764:3: ( (lv_steps_5_0= ruleStepRule ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=44 && LA13_0<=45)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:765:4: (lv_steps_5_0= ruleStepRule )
            	    {
            	    // InternalMachineLearningLanguage.g:765:4: (lv_steps_5_0= ruleStepRule )
            	    // InternalMachineLearningLanguage.g:766:5: lv_steps_5_0= ruleStepRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getPreparationPipelineDefinitionRuleAccess().getStepsStepRuleParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_33);
            	    lv_steps_5_0=ruleStepRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getPreparationPipelineDefinitionRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"steps",
            	      						lv_steps_5_0,
            	      						"de.evoal.languages.model.generator.dsl.GeneratorDSL.StepRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_6=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getPreparationPipelineDefinitionRuleAccess().getRightSquareBracketKeyword_6());
              		
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
    // $ANTLR end "rulePreparationPipelineDefinitionRule"


    // $ANTLR start "entryRuleLearningUseCaseRule"
    // InternalMachineLearningLanguage.g:791:1: entryRuleLearningUseCaseRule returns [EObject current=null] : iv_ruleLearningUseCaseRule= ruleLearningUseCaseRule EOF ;
    public final EObject entryRuleLearningUseCaseRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLearningUseCaseRule = null;


        try {
            // InternalMachineLearningLanguage.g:791:60: (iv_ruleLearningUseCaseRule= ruleLearningUseCaseRule EOF )
            // InternalMachineLearningLanguage.g:792:2: iv_ruleLearningUseCaseRule= ruleLearningUseCaseRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLearningUseCaseRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLearningUseCaseRule=ruleLearningUseCaseRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLearningUseCaseRule; 
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
    // $ANTLR end "entryRuleLearningUseCaseRule"


    // $ANTLR start "ruleLearningUseCaseRule"
    // InternalMachineLearningLanguage.g:798:1: ruleLearningUseCaseRule returns [EObject current=null] : ( () otherlv_1= 'specify' otherlv_2= 'learning' otherlv_3= 'begin' ( (lv_statements_4_0= ruleStatementRule ) )* otherlv_5= 'end' ) ;
    public final EObject ruleLearningUseCaseRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_statements_4_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:804:2: ( ( () otherlv_1= 'specify' otherlv_2= 'learning' otherlv_3= 'begin' ( (lv_statements_4_0= ruleStatementRule ) )* otherlv_5= 'end' ) )
            // InternalMachineLearningLanguage.g:805:2: ( () otherlv_1= 'specify' otherlv_2= 'learning' otherlv_3= 'begin' ( (lv_statements_4_0= ruleStatementRule ) )* otherlv_5= 'end' )
            {
            // InternalMachineLearningLanguage.g:805:2: ( () otherlv_1= 'specify' otherlv_2= 'learning' otherlv_3= 'begin' ( (lv_statements_4_0= ruleStatementRule ) )* otherlv_5= 'end' )
            // InternalMachineLearningLanguage.g:806:3: () otherlv_1= 'specify' otherlv_2= 'learning' otherlv_3= 'begin' ( (lv_statements_4_0= ruleStatementRule ) )* otherlv_5= 'end'
            {
            // InternalMachineLearningLanguage.g:806:3: ()
            // InternalMachineLearningLanguage.g:807:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLearningUseCaseRuleAccess().getBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,17,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLearningUseCaseRuleAccess().getSpecifyKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,30,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLearningUseCaseRuleAccess().getLearningKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,42,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getLearningUseCaseRuleAccess().getBeginKeyword_3());
              		
            }
            // InternalMachineLearningLanguage.g:828:3: ( (lv_statements_4_0= ruleStatementRule ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=RULE_QUOTED_ID && LA14_0<=RULE_ID)||LA14_0==49||LA14_0==53) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:829:4: (lv_statements_4_0= ruleStatementRule )
            	    {
            	    // InternalMachineLearningLanguage.g:829:4: (lv_statements_4_0= ruleStatementRule )
            	    // InternalMachineLearningLanguage.g:830:5: lv_statements_4_0= ruleStatementRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getLearningUseCaseRuleAccess().getStatementsStatementRuleParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_statements_4_0=ruleStatementRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getLearningUseCaseRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_4_0,
            	      						"de.evoal.languages.model.generator.dsl.GeneratorDSL.StatementRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_5=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getLearningUseCaseRuleAccess().getEndKeyword_5());
              		
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
    // $ANTLR end "ruleLearningUseCaseRule"


    // $ANTLR start "entryRulePredictionUseCaseRule"
    // InternalMachineLearningLanguage.g:855:1: entryRulePredictionUseCaseRule returns [EObject current=null] : iv_rulePredictionUseCaseRule= rulePredictionUseCaseRule EOF ;
    public final EObject entryRulePredictionUseCaseRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredictionUseCaseRule = null;


        try {
            // InternalMachineLearningLanguage.g:855:62: (iv_rulePredictionUseCaseRule= rulePredictionUseCaseRule EOF )
            // InternalMachineLearningLanguage.g:856:2: iv_rulePredictionUseCaseRule= rulePredictionUseCaseRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPredictionUseCaseRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePredictionUseCaseRule=rulePredictionUseCaseRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePredictionUseCaseRule; 
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
    // $ANTLR end "entryRulePredictionUseCaseRule"


    // $ANTLR start "rulePredictionUseCaseRule"
    // InternalMachineLearningLanguage.g:862:1: rulePredictionUseCaseRule returns [EObject current=null] : ( () otherlv_1= 'specify' ( (lv_name_2_0= 'predicting' ) ) otherlv_3= 'begin' ( (lv_steps_4_0= ruleStepRule ) )* otherlv_5= 'end' ) ;
    public final EObject rulePredictionUseCaseRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_steps_4_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:868:2: ( ( () otherlv_1= 'specify' ( (lv_name_2_0= 'predicting' ) ) otherlv_3= 'begin' ( (lv_steps_4_0= ruleStepRule ) )* otherlv_5= 'end' ) )
            // InternalMachineLearningLanguage.g:869:2: ( () otherlv_1= 'specify' ( (lv_name_2_0= 'predicting' ) ) otherlv_3= 'begin' ( (lv_steps_4_0= ruleStepRule ) )* otherlv_5= 'end' )
            {
            // InternalMachineLearningLanguage.g:869:2: ( () otherlv_1= 'specify' ( (lv_name_2_0= 'predicting' ) ) otherlv_3= 'begin' ( (lv_steps_4_0= ruleStepRule ) )* otherlv_5= 'end' )
            // InternalMachineLearningLanguage.g:870:3: () otherlv_1= 'specify' ( (lv_name_2_0= 'predicting' ) ) otherlv_3= 'begin' ( (lv_steps_4_0= ruleStepRule ) )* otherlv_5= 'end'
            {
            // InternalMachineLearningLanguage.g:870:3: ()
            // InternalMachineLearningLanguage.g:871:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPredictionUseCaseRuleAccess().getPipelineDefinitionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,17,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPredictionUseCaseRuleAccess().getSpecifyKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:884:3: ( (lv_name_2_0= 'predicting' ) )
            // InternalMachineLearningLanguage.g:885:4: (lv_name_2_0= 'predicting' )
            {
            // InternalMachineLearningLanguage.g:885:4: (lv_name_2_0= 'predicting' )
            // InternalMachineLearningLanguage.g:886:5: lv_name_2_0= 'predicting'
            {
            lv_name_2_0=(Token)match(input,43,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getPredictionUseCaseRuleAccess().getNamePredictingKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPredictionUseCaseRuleRule());
              					}
              					setWithLastConsumed(current, "name", lv_name_2_0, "predicting");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,42,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getPredictionUseCaseRuleAccess().getBeginKeyword_3());
              		
            }
            // InternalMachineLearningLanguage.g:902:3: ( (lv_steps_4_0= ruleStepRule ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=44 && LA15_0<=45)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:903:4: (lv_steps_4_0= ruleStepRule )
            	    {
            	    // InternalMachineLearningLanguage.g:903:4: (lv_steps_4_0= ruleStepRule )
            	    // InternalMachineLearningLanguage.g:904:5: lv_steps_4_0= ruleStepRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getPredictionUseCaseRuleAccess().getStepsStepRuleParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_steps_4_0=ruleStepRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getPredictionUseCaseRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"steps",
            	      						lv_steps_4_0,
            	      						"de.evoal.languages.model.generator.dsl.GeneratorDSL.StepRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_5=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getPredictionUseCaseRuleAccess().getEndKeyword_5());
              		
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
    // $ANTLR end "rulePredictionUseCaseRule"


    // $ANTLR start "entryRuleLiteralRule"
    // InternalMachineLearningLanguage.g:929:1: entryRuleLiteralRule returns [EObject current=null] : iv_ruleLiteralRule= ruleLiteralRule EOF ;
    public final EObject entryRuleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:929:52: (iv_ruleLiteralRule= ruleLiteralRule EOF )
            // InternalMachineLearningLanguage.g:930:2: iv_ruleLiteralRule= ruleLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:936:1: ruleLiteralRule returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule | this_StepRule_4= ruleStepRule ) ;
    public final EObject ruleLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_StringLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;

        EObject this_InstanceLiteralRule_3 = null;

        EObject this_StepRule_4 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:942:2: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule | this_StepRule_4= ruleStepRule ) )
            // InternalMachineLearningLanguage.g:943:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule | this_StepRule_4= ruleStepRule )
            {
            // InternalMachineLearningLanguage.g:943:2: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_StringLiteralRule_1= ruleStringLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_InstanceLiteralRule_3= ruleInstanceLiteralRule | this_StepRule_4= ruleStepRule )
            int alt16=5;
            switch ( input.LA(1) ) {
            case RULE_DOUBLE:
            case RULE_INT:
                {
                alt16=1;
                }
                break;
            case RULE_STRING:
                {
                alt16=2;
                }
                break;
            case 68:
            case 69:
                {
                alt16=3;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt16=4;
                }
                break;
            case 44:
            case 45:
                {
                alt16=5;
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
                    // InternalMachineLearningLanguage.g:944:3: this_NumberLiteralRule_0= ruleNumberLiteralRule
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
                    // InternalMachineLearningLanguage.g:956:3: this_StringLiteralRule_1= ruleStringLiteralRule
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
                    // InternalMachineLearningLanguage.g:968:3: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
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
                    // InternalMachineLearningLanguage.g:980:3: this_InstanceLiteralRule_3= ruleInstanceLiteralRule
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
                case 5 :
                    // InternalMachineLearningLanguage.g:992:3: this_StepRule_4= ruleStepRule
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralRuleAccess().getStepRuleParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StepRule_4=ruleStepRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StepRule_4;
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


    // $ANTLR start "entryRulePipelineDefinitionRule"
    // InternalMachineLearningLanguage.g:1007:1: entryRulePipelineDefinitionRule returns [EObject current=null] : iv_rulePipelineDefinitionRule= rulePipelineDefinitionRule EOF ;
    public final EObject entryRulePipelineDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineDefinitionRule = null;


        try {
            // InternalMachineLearningLanguage.g:1007:63: (iv_rulePipelineDefinitionRule= rulePipelineDefinitionRule EOF )
            // InternalMachineLearningLanguage.g:1008:2: iv_rulePipelineDefinitionRule= rulePipelineDefinitionRule EOF
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
    // InternalMachineLearningLanguage.g:1014:1: rulePipelineDefinitionRule returns [EObject current=null] : (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStepRule ) )* otherlv_4= ']' ) ;
    public final EObject rulePipelineDefinitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_steps_3_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1020:2: ( (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStepRule ) )* otherlv_4= ']' ) )
            // InternalMachineLearningLanguage.g:1021:2: (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStepRule ) )* otherlv_4= ']' )
            {
            // InternalMachineLearningLanguage.g:1021:2: (otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStepRule ) )* otherlv_4= ']' )
            // InternalMachineLearningLanguage.g:1022:3: otherlv_0= 'pipeline' ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStepRule ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPipelineDefinitionRuleAccess().getPipelineKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:1026:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:1027:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:1027:4: (lv_name_1_0= ruleStringOrId )
            // InternalMachineLearningLanguage.g:1028:5: lv_name_1_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPipelineDefinitionRuleAccess().getNameStringOrIdParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_23);
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

            otherlv_2=(Token)match(input,32,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPipelineDefinitionRuleAccess().getLeftSquareBracketKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:1049:3: ( (lv_steps_3_0= ruleStepRule ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=44 && LA17_0<=45)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1050:4: (lv_steps_3_0= ruleStepRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1050:4: (lv_steps_3_0= ruleStepRule )
            	    // InternalMachineLearningLanguage.g:1051:5: lv_steps_3_0= ruleStepRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getPipelineDefinitionRuleAccess().getStepsStepRuleParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_33);
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
            	    break loop17;
                }
            } while (true);

            otherlv_4=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:1076:1: entryRuleStepRule returns [EObject current=null] : iv_ruleStepRule= ruleStepRule EOF ;
    public final EObject entryRuleStepRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStepRule = null;


        try {
            // InternalMachineLearningLanguage.g:1076:49: (iv_ruleStepRule= ruleStepRule EOF )
            // InternalMachineLearningLanguage.g:1077:2: iv_ruleStepRule= ruleStepRule EOF
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
    // InternalMachineLearningLanguage.g:1083:1: ruleStepRule returns [EObject current=null] : (this_ConcreteStepRule_0= ruleConcreteStepRule | this_PipelineStepRule_1= rulePipelineStepRule ) ;
    public final EObject ruleStepRule() throws RecognitionException {
        EObject current = null;

        EObject this_ConcreteStepRule_0 = null;

        EObject this_PipelineStepRule_1 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1089:2: ( (this_ConcreteStepRule_0= ruleConcreteStepRule | this_PipelineStepRule_1= rulePipelineStepRule ) )
            // InternalMachineLearningLanguage.g:1090:2: (this_ConcreteStepRule_0= ruleConcreteStepRule | this_PipelineStepRule_1= rulePipelineStepRule )
            {
            // InternalMachineLearningLanguage.g:1090:2: (this_ConcreteStepRule_0= ruleConcreteStepRule | this_PipelineStepRule_1= rulePipelineStepRule )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==45) ) {
                alt18=1;
            }
            else if ( (LA18_0==44) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalMachineLearningLanguage.g:1091:3: this_ConcreteStepRule_0= ruleConcreteStepRule
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
                    // InternalMachineLearningLanguage.g:1103:3: this_PipelineStepRule_1= rulePipelineStepRule
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
    // InternalMachineLearningLanguage.g:1118:1: entryRuleConcreteStepRule returns [EObject current=null] : iv_ruleConcreteStepRule= ruleConcreteStepRule EOF ;
    public final EObject entryRuleConcreteStepRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteStepRule = null;


        try {
            // InternalMachineLearningLanguage.g:1118:57: (iv_ruleConcreteStepRule= ruleConcreteStepRule EOF )
            // InternalMachineLearningLanguage.g:1119:2: iv_ruleConcreteStepRule= ruleConcreteStepRule EOF
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
    // InternalMachineLearningLanguage.g:1125:1: ruleConcreteStepRule returns [EObject current=null] : (otherlv_0= 'step' otherlv_1= '{' otherlv_2= 'component' ( (lv_instance_3_0= ruleInstanceLiteralRule ) ) (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )? (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )? otherlv_18= '}' ) ;
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
            // InternalMachineLearningLanguage.g:1131:2: ( (otherlv_0= 'step' otherlv_1= '{' otherlv_2= 'component' ( (lv_instance_3_0= ruleInstanceLiteralRule ) ) (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )? (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )? otherlv_18= '}' ) )
            // InternalMachineLearningLanguage.g:1132:2: (otherlv_0= 'step' otherlv_1= '{' otherlv_2= 'component' ( (lv_instance_3_0= ruleInstanceLiteralRule ) ) (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )? (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )? otherlv_18= '}' )
            {
            // InternalMachineLearningLanguage.g:1132:2: (otherlv_0= 'step' otherlv_1= '{' otherlv_2= 'component' ( (lv_instance_3_0= ruleInstanceLiteralRule ) ) (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )? (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )? otherlv_18= '}' )
            // InternalMachineLearningLanguage.g:1133:3: otherlv_0= 'step' otherlv_1= '{' otherlv_2= 'component' ( (lv_instance_3_0= ruleInstanceLiteralRule ) ) (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )? (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )? otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConcreteStepRuleAccess().getStepKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,16,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getConcreteStepRuleAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,46,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConcreteStepRuleAccess().getComponentKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:1145:3: ( (lv_instance_3_0= ruleInstanceLiteralRule ) )
            // InternalMachineLearningLanguage.g:1146:4: (lv_instance_3_0= ruleInstanceLiteralRule )
            {
            // InternalMachineLearningLanguage.g:1146:4: (lv_instance_3_0= ruleInstanceLiteralRule )
            // InternalMachineLearningLanguage.g:1147:5: lv_instance_3_0= ruleInstanceLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConcreteStepRuleAccess().getInstanceInstanceLiteralRuleParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_40);
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

            // InternalMachineLearningLanguage.g:1164:3: (otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==47) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMachineLearningLanguage.g:1165:4: otherlv_4= 'reads' otherlv_5= '[' ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_9= ']' otherlv_10= ';'
                    {
                    otherlv_4=(Token)match(input,47,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getConcreteStepRuleAccess().getReadsKeyword_4_0());
                      			
                    }
                    otherlv_5=(Token)match(input,32,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getConcreteStepRuleAccess().getLeftSquareBracketKeyword_4_1());
                      			
                    }
                    // InternalMachineLearningLanguage.g:1173:4: ( ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )* )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==65) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalMachineLearningLanguage.g:1174:5: ( (lv_reads_6_0= ruleBaseDataReferenceRule ) ) (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )*
                            {
                            // InternalMachineLearningLanguage.g:1174:5: ( (lv_reads_6_0= ruleBaseDataReferenceRule ) )
                            // InternalMachineLearningLanguage.g:1175:6: (lv_reads_6_0= ruleBaseDataReferenceRule )
                            {
                            // InternalMachineLearningLanguage.g:1175:6: (lv_reads_6_0= ruleBaseDataReferenceRule )
                            // InternalMachineLearningLanguage.g:1176:7: lv_reads_6_0= ruleBaseDataReferenceRule
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getConcreteStepRuleAccess().getReadsBaseDataReferenceRuleParserRuleCall_4_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_25);
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

                            // InternalMachineLearningLanguage.g:1193:5: (otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) ) )*
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==28) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // InternalMachineLearningLanguage.g:1194:6: otherlv_7= ',' ( (lv_reads_8_0= ruleBaseDataReferenceRule ) )
                            	    {
                            	    otherlv_7=(Token)match(input,28,FOLLOW_42); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_7, grammarAccess.getConcreteStepRuleAccess().getCommaKeyword_4_2_1_0());
                            	      					
                            	    }
                            	    // InternalMachineLearningLanguage.g:1198:6: ( (lv_reads_8_0= ruleBaseDataReferenceRule ) )
                            	    // InternalMachineLearningLanguage.g:1199:7: (lv_reads_8_0= ruleBaseDataReferenceRule )
                            	    {
                            	    // InternalMachineLearningLanguage.g:1199:7: (lv_reads_8_0= ruleBaseDataReferenceRule )
                            	    // InternalMachineLearningLanguage.g:1200:8: lv_reads_8_0= ruleBaseDataReferenceRule
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getConcreteStepRuleAccess().getReadsBaseDataReferenceRuleParserRuleCall_4_2_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_25);
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
                            	    break loop19;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,33,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getConcreteStepRuleAccess().getRightSquareBracketKeyword_4_3());
                      			
                    }
                    otherlv_10=(Token)match(input,22,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getConcreteStepRuleAccess().getSemicolonKeyword_4_4());
                      			
                    }

                    }
                    break;

            }

            // InternalMachineLearningLanguage.g:1228:3: (otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==48) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMachineLearningLanguage.g:1229:4: otherlv_11= 'writes' otherlv_12= '[' ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )? otherlv_16= ']' otherlv_17= ';'
                    {
                    otherlv_11=(Token)match(input,48,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getConcreteStepRuleAccess().getWritesKeyword_5_0());
                      			
                    }
                    otherlv_12=(Token)match(input,32,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getConcreteStepRuleAccess().getLeftSquareBracketKeyword_5_1());
                      			
                    }
                    // InternalMachineLearningLanguage.g:1237:4: ( ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )* )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==65) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalMachineLearningLanguage.g:1238:5: ( (lv_writes_13_0= ruleBaseDataReferenceRule ) ) (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )*
                            {
                            // InternalMachineLearningLanguage.g:1238:5: ( (lv_writes_13_0= ruleBaseDataReferenceRule ) )
                            // InternalMachineLearningLanguage.g:1239:6: (lv_writes_13_0= ruleBaseDataReferenceRule )
                            {
                            // InternalMachineLearningLanguage.g:1239:6: (lv_writes_13_0= ruleBaseDataReferenceRule )
                            // InternalMachineLearningLanguage.g:1240:7: lv_writes_13_0= ruleBaseDataReferenceRule
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getConcreteStepRuleAccess().getWritesBaseDataReferenceRuleParserRuleCall_5_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_25);
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

                            // InternalMachineLearningLanguage.g:1257:5: (otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) ) )*
                            loop22:
                            do {
                                int alt22=2;
                                int LA22_0 = input.LA(1);

                                if ( (LA22_0==28) ) {
                                    alt22=1;
                                }


                                switch (alt22) {
                            	case 1 :
                            	    // InternalMachineLearningLanguage.g:1258:6: otherlv_14= ',' ( (lv_writes_15_0= ruleBaseDataReferenceRule ) )
                            	    {
                            	    otherlv_14=(Token)match(input,28,FOLLOW_42); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_14, grammarAccess.getConcreteStepRuleAccess().getCommaKeyword_5_2_1_0());
                            	      					
                            	    }
                            	    // InternalMachineLearningLanguage.g:1262:6: ( (lv_writes_15_0= ruleBaseDataReferenceRule ) )
                            	    // InternalMachineLearningLanguage.g:1263:7: (lv_writes_15_0= ruleBaseDataReferenceRule )
                            	    {
                            	    // InternalMachineLearningLanguage.g:1263:7: (lv_writes_15_0= ruleBaseDataReferenceRule )
                            	    // InternalMachineLearningLanguage.g:1264:8: lv_writes_15_0= ruleBaseDataReferenceRule
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getConcreteStepRuleAccess().getWritesBaseDataReferenceRuleParserRuleCall_5_2_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_25);
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
                            	    break loop22;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_16=(Token)match(input,33,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getConcreteStepRuleAccess().getRightSquareBracketKeyword_5_3());
                      			
                    }
                    otherlv_17=(Token)match(input,22,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getConcreteStepRuleAccess().getSemicolonKeyword_5_4());
                      			
                    }

                    }
                    break;

            }

            otherlv_18=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:1300:1: entryRulePipelineStepRule returns [EObject current=null] : iv_rulePipelineStepRule= rulePipelineStepRule EOF ;
    public final EObject entryRulePipelineStepRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStepRule = null;


        try {
            // InternalMachineLearningLanguage.g:1300:57: (iv_rulePipelineStepRule= rulePipelineStepRule EOF )
            // InternalMachineLearningLanguage.g:1301:2: iv_rulePipelineStepRule= rulePipelineStepRule EOF
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
    // InternalMachineLearningLanguage.g:1307:1: rulePipelineStepRule returns [EObject current=null] : (otherlv_0= 'pipeline' ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePipelineStepRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1313:2: ( (otherlv_0= 'pipeline' ( ( ruleQualifiedName ) ) ) )
            // InternalMachineLearningLanguage.g:1314:2: (otherlv_0= 'pipeline' ( ( ruleQualifiedName ) ) )
            {
            // InternalMachineLearningLanguage.g:1314:2: (otherlv_0= 'pipeline' ( ( ruleQualifiedName ) ) )
            // InternalMachineLearningLanguage.g:1315:3: otherlv_0= 'pipeline' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPipelineStepRuleAccess().getPipelineKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:1319:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:1320:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:1320:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:1321:5: ruleQualifiedName
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
    // InternalMachineLearningLanguage.g:1342:1: entryRuleBodyRule returns [EObject current=null] : iv_ruleBodyRule= ruleBodyRule EOF ;
    public final EObject entryRuleBodyRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBodyRule = null;


        try {
            // InternalMachineLearningLanguage.g:1342:49: (iv_ruleBodyRule= ruleBodyRule EOF )
            // InternalMachineLearningLanguage.g:1343:2: iv_ruleBodyRule= ruleBodyRule EOF
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
    // InternalMachineLearningLanguage.g:1349:1: ruleBodyRule returns [EObject current=null] : ( () otherlv_1= 'begin' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= 'end' ) ;
    public final EObject ruleBodyRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1355:2: ( ( () otherlv_1= 'begin' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= 'end' ) )
            // InternalMachineLearningLanguage.g:1356:2: ( () otherlv_1= 'begin' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= 'end' )
            {
            // InternalMachineLearningLanguage.g:1356:2: ( () otherlv_1= 'begin' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= 'end' )
            // InternalMachineLearningLanguage.g:1357:3: () otherlv_1= 'begin' ( (lv_statements_2_0= ruleStatementRule ) )* otherlv_3= 'end'
            {
            // InternalMachineLearningLanguage.g:1357:3: ()
            // InternalMachineLearningLanguage.g:1358:4: 
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

            otherlv_1=(Token)match(input,42,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBodyRuleAccess().getBeginKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:1371:3: ( (lv_statements_2_0= ruleStatementRule ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=RULE_QUOTED_ID && LA25_0<=RULE_ID)||LA25_0==49||LA25_0==53) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1372:4: (lv_statements_2_0= ruleStatementRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1372:4: (lv_statements_2_0= ruleStatementRule )
            	    // InternalMachineLearningLanguage.g:1373:5: lv_statements_2_0= ruleStatementRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBodyRuleAccess().getStatementsStatementRuleParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_36);
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
            	    break loop25;
                }
            } while (true);

            otherlv_3=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:1398:1: entryRuleStatementRule returns [EObject current=null] : iv_ruleStatementRule= ruleStatementRule EOF ;
    public final EObject entryRuleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementRule = null;


        try {
            // InternalMachineLearningLanguage.g:1398:54: (iv_ruleStatementRule= ruleStatementRule EOF )
            // InternalMachineLearningLanguage.g:1399:2: iv_ruleStatementRule= ruleStatementRule EOF
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
    // InternalMachineLearningLanguage.g:1405:1: ruleStatementRule returns [EObject current=null] : (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule | this_CallBuiltInFunctionRule_2= ruleCallBuiltInFunctionRule ) ;
    public final EObject ruleStatementRule() throws RecognitionException {
        EObject current = null;

        EObject this_ForStatementRule_0 = null;

        EObject this_ApplyStatementRule_1 = null;

        EObject this_CallBuiltInFunctionRule_2 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1411:2: ( (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule | this_CallBuiltInFunctionRule_2= ruleCallBuiltInFunctionRule ) )
            // InternalMachineLearningLanguage.g:1412:2: (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule | this_CallBuiltInFunctionRule_2= ruleCallBuiltInFunctionRule )
            {
            // InternalMachineLearningLanguage.g:1412:2: (this_ForStatementRule_0= ruleForStatementRule | this_ApplyStatementRule_1= ruleApplyStatementRule | this_CallBuiltInFunctionRule_2= ruleCallBuiltInFunctionRule )
            int alt26=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt26=1;
                }
                break;
            case 53:
                {
                alt26=2;
                }
                break;
            case RULE_QUOTED_ID:
            case RULE_ID:
                {
                alt26=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalMachineLearningLanguage.g:1413:3: this_ForStatementRule_0= ruleForStatementRule
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
                    // InternalMachineLearningLanguage.g:1425:3: this_ApplyStatementRule_1= ruleApplyStatementRule
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
                    // InternalMachineLearningLanguage.g:1437:3: this_CallBuiltInFunctionRule_2= ruleCallBuiltInFunctionRule
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
    // InternalMachineLearningLanguage.g:1452:1: entryRuleForStatementRule returns [EObject current=null] : iv_ruleForStatementRule= ruleForStatementRule EOF ;
    public final EObject entryRuleForStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatementRule = null;


        try {
            // InternalMachineLearningLanguage.g:1452:57: (iv_ruleForStatementRule= ruleForStatementRule EOF )
            // InternalMachineLearningLanguage.g:1453:2: iv_ruleForStatementRule= ruleForStatementRule EOF
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
    // InternalMachineLearningLanguage.g:1459:1: ruleForStatementRule returns [EObject current=null] : (otherlv_0= 'for' ( (lv_var_1_0= ruleNamedVariableRule ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) ( (lv_body_4_0= ruleBodyRule ) ) ) ;
    public final EObject ruleForStatementRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_var_1_0 = null;

        EObject lv_range_3_0 = null;

        EObject lv_body_4_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1465:2: ( (otherlv_0= 'for' ( (lv_var_1_0= ruleNamedVariableRule ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) ( (lv_body_4_0= ruleBodyRule ) ) ) )
            // InternalMachineLearningLanguage.g:1466:2: (otherlv_0= 'for' ( (lv_var_1_0= ruleNamedVariableRule ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) ( (lv_body_4_0= ruleBodyRule ) ) )
            {
            // InternalMachineLearningLanguage.g:1466:2: (otherlv_0= 'for' ( (lv_var_1_0= ruleNamedVariableRule ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) ( (lv_body_4_0= ruleBodyRule ) ) )
            // InternalMachineLearningLanguage.g:1467:3: otherlv_0= 'for' ( (lv_var_1_0= ruleNamedVariableRule ) ) otherlv_2= 'in' ( (lv_range_3_0= ruleRangeRule ) ) ( (lv_body_4_0= ruleBodyRule ) )
            {
            otherlv_0=(Token)match(input,49,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getForStatementRuleAccess().getForKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:1471:3: ( (lv_var_1_0= ruleNamedVariableRule ) )
            // InternalMachineLearningLanguage.g:1472:4: (lv_var_1_0= ruleNamedVariableRule )
            {
            // InternalMachineLearningLanguage.g:1472:4: (lv_var_1_0= ruleNamedVariableRule )
            // InternalMachineLearningLanguage.g:1473:5: lv_var_1_0= ruleNamedVariableRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForStatementRuleAccess().getVarNamedVariableRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_44);
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

            otherlv_2=(Token)match(input,50,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getForStatementRuleAccess().getInKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:1494:3: ( (lv_range_3_0= ruleRangeRule ) )
            // InternalMachineLearningLanguage.g:1495:4: (lv_range_3_0= ruleRangeRule )
            {
            // InternalMachineLearningLanguage.g:1495:4: (lv_range_3_0= ruleRangeRule )
            // InternalMachineLearningLanguage.g:1496:5: lv_range_3_0= ruleRangeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForStatementRuleAccess().getRangeRangeRuleParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_10);
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

            // InternalMachineLearningLanguage.g:1513:3: ( (lv_body_4_0= ruleBodyRule ) )
            // InternalMachineLearningLanguage.g:1514:4: (lv_body_4_0= ruleBodyRule )
            {
            // InternalMachineLearningLanguage.g:1514:4: (lv_body_4_0= ruleBodyRule )
            // InternalMachineLearningLanguage.g:1515:5: lv_body_4_0= ruleBodyRule
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
    // InternalMachineLearningLanguage.g:1536:1: entryRuleNamedVariableRule returns [EObject current=null] : iv_ruleNamedVariableRule= ruleNamedVariableRule EOF ;
    public final EObject entryRuleNamedVariableRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedVariableRule = null;


        try {
            // InternalMachineLearningLanguage.g:1536:58: (iv_ruleNamedVariableRule= ruleNamedVariableRule EOF )
            // InternalMachineLearningLanguage.g:1537:2: iv_ruleNamedVariableRule= ruleNamedVariableRule EOF
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
    // InternalMachineLearningLanguage.g:1543:1: ruleNamedVariableRule returns [EObject current=null] : ( (lv_name_0_0= ruleStringOrId ) ) ;
    public final EObject ruleNamedVariableRule() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1549:2: ( ( (lv_name_0_0= ruleStringOrId ) ) )
            // InternalMachineLearningLanguage.g:1550:2: ( (lv_name_0_0= ruleStringOrId ) )
            {
            // InternalMachineLearningLanguage.g:1550:2: ( (lv_name_0_0= ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:1551:3: (lv_name_0_0= ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:1551:3: (lv_name_0_0= ruleStringOrId )
            // InternalMachineLearningLanguage.g:1552:4: lv_name_0_0= ruleStringOrId
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
    // InternalMachineLearningLanguage.g:1572:1: entryRuleRangeRule returns [EObject current=null] : iv_ruleRangeRule= ruleRangeRule EOF ;
    public final EObject entryRuleRangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeRule = null;


        try {
            // InternalMachineLearningLanguage.g:1572:50: (iv_ruleRangeRule= ruleRangeRule EOF )
            // InternalMachineLearningLanguage.g:1573:2: iv_ruleRangeRule= ruleRangeRule EOF
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
    // InternalMachineLearningLanguage.g:1579:1: ruleRangeRule returns [EObject current=null] : (this_CounterRangeRule_0= ruleCounterRangeRule | this_LiteralRangeRule_1= ruleLiteralRangeRule ) ;
    public final EObject ruleRangeRule() throws RecognitionException {
        EObject current = null;

        EObject this_CounterRangeRule_0 = null;

        EObject this_LiteralRangeRule_1 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1585:2: ( (this_CounterRangeRule_0= ruleCounterRangeRule | this_LiteralRangeRule_1= ruleLiteralRangeRule ) )
            // InternalMachineLearningLanguage.g:1586:2: (this_CounterRangeRule_0= ruleCounterRangeRule | this_LiteralRangeRule_1= ruleLiteralRangeRule )
            {
            // InternalMachineLearningLanguage.g:1586:2: (this_CounterRangeRule_0= ruleCounterRangeRule | this_LiteralRangeRule_1= ruleLiteralRangeRule )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalMachineLearningLanguage.g:1587:3: this_CounterRangeRule_0= ruleCounterRangeRule
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
                    // InternalMachineLearningLanguage.g:1599:3: this_LiteralRangeRule_1= ruleLiteralRangeRule
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
    // InternalMachineLearningLanguage.g:1614:1: entryRuleLiteralRangeRule returns [EObject current=null] : iv_ruleLiteralRangeRule= ruleLiteralRangeRule EOF ;
    public final EObject entryRuleLiteralRangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRangeRule = null;


        try {
            // InternalMachineLearningLanguage.g:1614:57: (iv_ruleLiteralRangeRule= ruleLiteralRangeRule EOF )
            // InternalMachineLearningLanguage.g:1615:2: iv_ruleLiteralRangeRule= ruleLiteralRangeRule EOF
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
    // InternalMachineLearningLanguage.g:1621:1: ruleLiteralRangeRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_elements_1_0= ruleReadExpressionRule ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleReadExpressionRule ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleLiteralRangeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_1_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1627:2: ( (otherlv_0= '[' ( (lv_elements_1_0= ruleReadExpressionRule ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleReadExpressionRule ) ) )* otherlv_4= ']' ) )
            // InternalMachineLearningLanguage.g:1628:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleReadExpressionRule ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleReadExpressionRule ) ) )* otherlv_4= ']' )
            {
            // InternalMachineLearningLanguage.g:1628:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleReadExpressionRule ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleReadExpressionRule ) ) )* otherlv_4= ']' )
            // InternalMachineLearningLanguage.g:1629:3: otherlv_0= '[' ( (lv_elements_1_0= ruleReadExpressionRule ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleReadExpressionRule ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLiteralRangeRuleAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:1633:3: ( (lv_elements_1_0= ruleReadExpressionRule ) )
            // InternalMachineLearningLanguage.g:1634:4: (lv_elements_1_0= ruleReadExpressionRule )
            {
            // InternalMachineLearningLanguage.g:1634:4: (lv_elements_1_0= ruleReadExpressionRule )
            // InternalMachineLearningLanguage.g:1635:5: lv_elements_1_0= ruleReadExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLiteralRangeRuleAccess().getElementsReadExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_25);
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

            // InternalMachineLearningLanguage.g:1652:3: (otherlv_2= ',' ( (lv_elements_3_0= ruleReadExpressionRule ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==28) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1653:4: otherlv_2= ',' ( (lv_elements_3_0= ruleReadExpressionRule ) )
            	    {
            	    otherlv_2=(Token)match(input,28,FOLLOW_45); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getLiteralRangeRuleAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:1657:4: ( (lv_elements_3_0= ruleReadExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:1658:5: (lv_elements_3_0= ruleReadExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1658:5: (lv_elements_3_0= ruleReadExpressionRule )
            	    // InternalMachineLearningLanguage.g:1659:6: lv_elements_3_0= ruleReadExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLiteralRangeRuleAccess().getElementsReadExpressionRuleParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_25);
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
            	    break loop28;
                }
            } while (true);

            otherlv_4=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:1685:1: entryRuleCounterRangeRule returns [EObject current=null] : iv_ruleCounterRangeRule= ruleCounterRangeRule EOF ;
    public final EObject entryRuleCounterRangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCounterRangeRule = null;


        try {
            // InternalMachineLearningLanguage.g:1685:57: (iv_ruleCounterRangeRule= ruleCounterRangeRule EOF )
            // InternalMachineLearningLanguage.g:1686:2: iv_ruleCounterRangeRule= ruleCounterRangeRule EOF
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
    // InternalMachineLearningLanguage.g:1692:1: ruleCounterRangeRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_start_1_0= ruleIntegerLiteralRule ) ) otherlv_2= 'to' ( (lv_end_3_0= ruleIntegerLiteralRule ) ) otherlv_4= 'increment' otherlv_5= 'by' ( (lv_increment_6_0= ruleIntegerLiteralRule ) ) otherlv_7= ']' ) ;
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
            // InternalMachineLearningLanguage.g:1698:2: ( (otherlv_0= '[' ( (lv_start_1_0= ruleIntegerLiteralRule ) ) otherlv_2= 'to' ( (lv_end_3_0= ruleIntegerLiteralRule ) ) otherlv_4= 'increment' otherlv_5= 'by' ( (lv_increment_6_0= ruleIntegerLiteralRule ) ) otherlv_7= ']' ) )
            // InternalMachineLearningLanguage.g:1699:2: (otherlv_0= '[' ( (lv_start_1_0= ruleIntegerLiteralRule ) ) otherlv_2= 'to' ( (lv_end_3_0= ruleIntegerLiteralRule ) ) otherlv_4= 'increment' otherlv_5= 'by' ( (lv_increment_6_0= ruleIntegerLiteralRule ) ) otherlv_7= ']' )
            {
            // InternalMachineLearningLanguage.g:1699:2: (otherlv_0= '[' ( (lv_start_1_0= ruleIntegerLiteralRule ) ) otherlv_2= 'to' ( (lv_end_3_0= ruleIntegerLiteralRule ) ) otherlv_4= 'increment' otherlv_5= 'by' ( (lv_increment_6_0= ruleIntegerLiteralRule ) ) otherlv_7= ']' )
            // InternalMachineLearningLanguage.g:1700:3: otherlv_0= '[' ( (lv_start_1_0= ruleIntegerLiteralRule ) ) otherlv_2= 'to' ( (lv_end_3_0= ruleIntegerLiteralRule ) ) otherlv_4= 'increment' otherlv_5= 'by' ( (lv_increment_6_0= ruleIntegerLiteralRule ) ) otherlv_7= ']'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCounterRangeRuleAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:1704:3: ( (lv_start_1_0= ruleIntegerLiteralRule ) )
            // InternalMachineLearningLanguage.g:1705:4: (lv_start_1_0= ruleIntegerLiteralRule )
            {
            // InternalMachineLearningLanguage.g:1705:4: (lv_start_1_0= ruleIntegerLiteralRule )
            // InternalMachineLearningLanguage.g:1706:5: lv_start_1_0= ruleIntegerLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCounterRangeRuleAccess().getStartIntegerLiteralRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_29);
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

            otherlv_2=(Token)match(input,37,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCounterRangeRuleAccess().getToKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:1727:3: ( (lv_end_3_0= ruleIntegerLiteralRule ) )
            // InternalMachineLearningLanguage.g:1728:4: (lv_end_3_0= ruleIntegerLiteralRule )
            {
            // InternalMachineLearningLanguage.g:1728:4: (lv_end_3_0= ruleIntegerLiteralRule )
            // InternalMachineLearningLanguage.g:1729:5: lv_end_3_0= ruleIntegerLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCounterRangeRuleAccess().getEndIntegerLiteralRuleParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_47);
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

            otherlv_4=(Token)match(input,51,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getCounterRangeRuleAccess().getIncrementKeyword_4());
              		
            }
            otherlv_5=(Token)match(input,52,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCounterRangeRuleAccess().getByKeyword_5());
              		
            }
            // InternalMachineLearningLanguage.g:1754:3: ( (lv_increment_6_0= ruleIntegerLiteralRule ) )
            // InternalMachineLearningLanguage.g:1755:4: (lv_increment_6_0= ruleIntegerLiteralRule )
            {
            // InternalMachineLearningLanguage.g:1755:4: (lv_increment_6_0= ruleIntegerLiteralRule )
            // InternalMachineLearningLanguage.g:1756:5: lv_increment_6_0= ruleIntegerLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCounterRangeRuleAccess().getIncrementIntegerLiteralRuleParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_49);
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

            otherlv_7=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:1781:1: entryRuleApplyStatementRule returns [EObject current=null] : iv_ruleApplyStatementRule= ruleApplyStatementRule EOF ;
    public final EObject entryRuleApplyStatementRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApplyStatementRule = null;


        try {
            // InternalMachineLearningLanguage.g:1781:59: (iv_ruleApplyStatementRule= ruleApplyStatementRule EOF )
            // InternalMachineLearningLanguage.g:1782:2: iv_ruleApplyStatementRule= ruleApplyStatementRule EOF
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
    // InternalMachineLearningLanguage.g:1788:1: ruleApplyStatementRule returns [EObject current=null] : (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= ruleLiteralRule ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= ruleVariableReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= ruleVariableReferenceRule ) ) )* otherlv_11= ']' otherlv_12= ';' ) ;
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
            // InternalMachineLearningLanguage.g:1794:2: ( (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= ruleLiteralRule ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= ruleVariableReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= ruleVariableReferenceRule ) ) )* otherlv_11= ']' otherlv_12= ';' ) )
            // InternalMachineLearningLanguage.g:1795:2: (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= ruleLiteralRule ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= ruleVariableReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= ruleVariableReferenceRule ) ) )* otherlv_11= ']' otherlv_12= ';' )
            {
            // InternalMachineLearningLanguage.g:1795:2: (otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= ruleLiteralRule ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= ruleVariableReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= ruleVariableReferenceRule ) ) )* otherlv_11= ']' otherlv_12= ';' )
            // InternalMachineLearningLanguage.g:1796:3: otherlv_0= 'write' ( (lv_file_1_0= RULE_STRING ) ) otherlv_2= 'with' ( (lv_count_3_0= ruleLiteralRule ) ) otherlv_4= 'samples' otherlv_5= 'from' otherlv_6= 'executing' otherlv_7= '[' ( (lv_pipelines_8_0= ruleVariableReferenceRule ) ) (otherlv_9= ',' ( (lv_pipelines_10_0= ruleVariableReferenceRule ) ) )* otherlv_11= ']' otherlv_12= ';'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getApplyStatementRuleAccess().getWriteKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:1800:3: ( (lv_file_1_0= RULE_STRING ) )
            // InternalMachineLearningLanguage.g:1801:4: (lv_file_1_0= RULE_STRING )
            {
            // InternalMachineLearningLanguage.g:1801:4: (lv_file_1_0= RULE_STRING )
            // InternalMachineLearningLanguage.g:1802:5: lv_file_1_0= RULE_STRING
            {
            lv_file_1_0=(Token)match(input,RULE_STRING,FOLLOW_27); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,35,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getApplyStatementRuleAccess().getWithKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:1822:3: ( (lv_count_3_0= ruleLiteralRule ) )
            // InternalMachineLearningLanguage.g:1823:4: (lv_count_3_0= ruleLiteralRule )
            {
            // InternalMachineLearningLanguage.g:1823:4: (lv_count_3_0= ruleLiteralRule )
            // InternalMachineLearningLanguage.g:1824:5: lv_count_3_0= ruleLiteralRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getApplyStatementRuleAccess().getCountLiteralRuleParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_51);
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
              						"de.evoal.languages.model.mll.dsl.MachineLearningLanguage.LiteralRule");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,54,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getApplyStatementRuleAccess().getSamplesKeyword_4());
              		
            }
            otherlv_5=(Token)match(input,31,FOLLOW_52); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getApplyStatementRuleAccess().getFromKeyword_5());
              		
            }
            otherlv_6=(Token)match(input,55,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getApplyStatementRuleAccess().getExecutingKeyword_6());
              		
            }
            otherlv_7=(Token)match(input,32,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getApplyStatementRuleAccess().getLeftSquareBracketKeyword_7());
              		
            }
            // InternalMachineLearningLanguage.g:1857:3: ( (lv_pipelines_8_0= ruleVariableReferenceRule ) )
            // InternalMachineLearningLanguage.g:1858:4: (lv_pipelines_8_0= ruleVariableReferenceRule )
            {
            // InternalMachineLearningLanguage.g:1858:4: (lv_pipelines_8_0= ruleVariableReferenceRule )
            // InternalMachineLearningLanguage.g:1859:5: lv_pipelines_8_0= ruleVariableReferenceRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getApplyStatementRuleAccess().getPipelinesVariableReferenceRuleParserRuleCall_8_0());
              				
            }
            pushFollow(FOLLOW_25);
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

            // InternalMachineLearningLanguage.g:1876:3: (otherlv_9= ',' ( (lv_pipelines_10_0= ruleVariableReferenceRule ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==28) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:1877:4: otherlv_9= ',' ( (lv_pipelines_10_0= ruleVariableReferenceRule ) )
            	    {
            	    otherlv_9=(Token)match(input,28,FOLLOW_45); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_9, grammarAccess.getApplyStatementRuleAccess().getCommaKeyword_9_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:1881:4: ( (lv_pipelines_10_0= ruleVariableReferenceRule ) )
            	    // InternalMachineLearningLanguage.g:1882:5: (lv_pipelines_10_0= ruleVariableReferenceRule )
            	    {
            	    // InternalMachineLearningLanguage.g:1882:5: (lv_pipelines_10_0= ruleVariableReferenceRule )
            	    // InternalMachineLearningLanguage.g:1883:6: lv_pipelines_10_0= ruleVariableReferenceRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getApplyStatementRuleAccess().getPipelinesVariableReferenceRuleParserRuleCall_9_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_25);
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
            	    break loop29;
                }
            } while (true);

            otherlv_11=(Token)match(input,33,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getApplyStatementRuleAccess().getRightSquareBracketKeyword_10());
              		
            }
            otherlv_12=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:1913:1: entryRuleReferenceRule returns [EObject current=null] : iv_ruleReferenceRule= ruleReferenceRule EOF ;
    public final EObject entryRuleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:1913:54: (iv_ruleReferenceRule= ruleReferenceRule EOF )
            // InternalMachineLearningLanguage.g:1914:2: iv_ruleReferenceRule= ruleReferenceRule EOF
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
    // InternalMachineLearningLanguage.g:1920:1: ruleReferenceRule returns [EObject current=null] : (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_TypeDefinitionReferenceRule_1= ruleTypeDefinitionReferenceRule | this_VariableReferenceRule_2= ruleVariableReferenceRule ) ;
    public final EObject ruleReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_ValuelDefinitionReferenceRule_0 = null;

        EObject this_TypeDefinitionReferenceRule_1 = null;

        EObject this_VariableReferenceRule_2 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1926:2: ( (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_TypeDefinitionReferenceRule_1= ruleTypeDefinitionReferenceRule | this_VariableReferenceRule_2= ruleVariableReferenceRule ) )
            // InternalMachineLearningLanguage.g:1927:2: (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_TypeDefinitionReferenceRule_1= ruleTypeDefinitionReferenceRule | this_VariableReferenceRule_2= ruleVariableReferenceRule )
            {
            // InternalMachineLearningLanguage.g:1927:2: (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule | this_TypeDefinitionReferenceRule_1= ruleTypeDefinitionReferenceRule | this_VariableReferenceRule_2= ruleVariableReferenceRule )
            int alt30=3;
            switch ( input.LA(1) ) {
            case RULE_QUOTED_ID:
                {
                int LA30_1 = input.LA(2);

                if ( (synpred34_InternalMachineLearningLanguage()) ) {
                    alt30=1;
                }
                else if ( (true) ) {
                    alt30=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA30_2 = input.LA(2);

                if ( (synpred34_InternalMachineLearningLanguage()) ) {
                    alt30=1;
                }
                else if ( (true) ) {
                    alt30=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 2, input);

                    throw nvae;
                }
                }
                break;
            case 65:
            case 66:
                {
                alt30=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalMachineLearningLanguage.g:1928:3: this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule
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
                    // InternalMachineLearningLanguage.g:1940:3: this_TypeDefinitionReferenceRule_1= ruleTypeDefinitionReferenceRule
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
                    // InternalMachineLearningLanguage.g:1952:3: this_VariableReferenceRule_2= ruleVariableReferenceRule
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
    // InternalMachineLearningLanguage.g:1967:1: entryRuleVariableReferenceRule returns [EObject current=null] : iv_ruleVariableReferenceRule= ruleVariableReferenceRule EOF ;
    public final EObject entryRuleVariableReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:1967:62: (iv_ruleVariableReferenceRule= ruleVariableReferenceRule EOF )
            // InternalMachineLearningLanguage.g:1968:2: iv_ruleVariableReferenceRule= ruleVariableReferenceRule EOF
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
    // InternalMachineLearningLanguage.g:1974:1: ruleVariableReferenceRule returns [EObject current=null] : ( ( ruleStringOrId ) ) ;
    public final EObject ruleVariableReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:1980:2: ( ( ( ruleStringOrId ) ) )
            // InternalMachineLearningLanguage.g:1981:2: ( ( ruleStringOrId ) )
            {
            // InternalMachineLearningLanguage.g:1981:2: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:1982:3: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:1982:3: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:1983:4: ruleStringOrId
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
    // InternalMachineLearningLanguage.g:2003:1: entryRuleCallBuiltInFunctionRule returns [EObject current=null] : iv_ruleCallBuiltInFunctionRule= ruleCallBuiltInFunctionRule EOF ;
    public final EObject entryRuleCallBuiltInFunctionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallBuiltInFunctionRule = null;


        try {
            // InternalMachineLearningLanguage.g:2003:64: (iv_ruleCallBuiltInFunctionRule= ruleCallBuiltInFunctionRule EOF )
            // InternalMachineLearningLanguage.g:2004:2: iv_ruleCallBuiltInFunctionRule= ruleCallBuiltInFunctionRule EOF
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
    // InternalMachineLearningLanguage.g:2010:1: ruleCallBuiltInFunctionRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalMachineLearningLanguage.g:2016:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' otherlv_6= ';' ) )
            // InternalMachineLearningLanguage.g:2017:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalMachineLearningLanguage.g:2017:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' otherlv_6= ';' )
            // InternalMachineLearningLanguage.g:2018:3: ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' otherlv_6= ';'
            {
            // InternalMachineLearningLanguage.g:2018:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:2019:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:2019:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:2020:5: ruleQualifiedName
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
            pushFollow(FOLLOW_53);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,56,FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallBuiltInFunctionRuleAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:2041:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_STRING && LA32_0<=RULE_ID)||LA32_0==32||(LA32_0>=44 && LA32_0<=45)||LA32_0==56||LA32_0==61||(LA32_0>=65 && LA32_0<=66)||(LA32_0>=68 && LA32_0<=69)||(LA32_0>=90 && LA32_0<=91)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2042:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalMachineLearningLanguage.g:2042:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalMachineLearningLanguage.g:2043:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalMachineLearningLanguage.g:2043:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalMachineLearningLanguage.g:2044:6: lv_parameters_2_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallBuiltInFunctionRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_55);
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

                    // InternalMachineLearningLanguage.g:2061:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==28) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalMachineLearningLanguage.g:2062:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,28,FOLLOW_56); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getCallBuiltInFunctionRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalMachineLearningLanguage.g:2066:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalMachineLearningLanguage.g:2067:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalMachineLearningLanguage.g:2067:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalMachineLearningLanguage.g:2068:7: lv_parameters_4_0= ruleExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCallBuiltInFunctionRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_55);
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
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,57,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCallBuiltInFunctionRuleAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_6=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:2099:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:2099:55: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // InternalMachineLearningLanguage.g:2100:2: iv_ruleExpressionRule= ruleExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:2106:1: ruleExpressionRule returns [EObject current=null] : this_OrExpressionRule_0= ruleOrExpressionRule ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpressionRule_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2112:2: (this_OrExpressionRule_0= ruleOrExpressionRule )
            // InternalMachineLearningLanguage.g:2113:2: this_OrExpressionRule_0= ruleOrExpressionRule
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
    // InternalMachineLearningLanguage.g:2127:1: entryRuleOrExpressionRule returns [EObject current=null] : iv_ruleOrExpressionRule= ruleOrExpressionRule EOF ;
    public final EObject entryRuleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:2127:57: (iv_ruleOrExpressionRule= ruleOrExpressionRule EOF )
            // InternalMachineLearningLanguage.g:2128:2: iv_ruleOrExpressionRule= ruleOrExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:2134:1: ruleOrExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) ;
    public final EObject ruleOrExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2140:2: ( ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* ) )
            // InternalMachineLearningLanguage.g:2141:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            {
            // InternalMachineLearningLanguage.g:2141:2: ( ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )* )
            // InternalMachineLearningLanguage.g:2142:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) ) (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            {
            // InternalMachineLearningLanguage.g:2142:3: ( (lv_subExpressions_0_0= ruleXorExpressionRule ) )
            // InternalMachineLearningLanguage.g:2143:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            {
            // InternalMachineLearningLanguage.g:2143:4: (lv_subExpressions_0_0= ruleXorExpressionRule )
            // InternalMachineLearningLanguage.g:2144:5: lv_subExpressions_0_0= ruleXorExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_57);
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

            // InternalMachineLearningLanguage.g:2161:3: (otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==58) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:2162:4: otherlv_1= 'OR' ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,58,FOLLOW_56); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getOrExpressionRuleAccess().getORKeyword_1_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:2166:4: ( (lv_subExpressions_2_0= ruleXorExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:2167:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:2167:5: (lv_subExpressions_2_0= ruleXorExpressionRule )
            	    // InternalMachineLearningLanguage.g:2168:6: lv_subExpressions_2_0= ruleXorExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionRuleAccess().getSubExpressionsXorExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_57);
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
            	    break loop33;
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
    // InternalMachineLearningLanguage.g:2190:1: entryRuleXorExpressionRule returns [EObject current=null] : iv_ruleXorExpressionRule= ruleXorExpressionRule EOF ;
    public final EObject entryRuleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:2190:58: (iv_ruleXorExpressionRule= ruleXorExpressionRule EOF )
            // InternalMachineLearningLanguage.g:2191:2: iv_ruleXorExpressionRule= ruleXorExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:2197:1: ruleXorExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) ;
    public final EObject ruleXorExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2203:2: ( ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* ) )
            // InternalMachineLearningLanguage.g:2204:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            {
            // InternalMachineLearningLanguage.g:2204:2: ( ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )* )
            // InternalMachineLearningLanguage.g:2205:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) ) (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            {
            // InternalMachineLearningLanguage.g:2205:3: ( (lv_subExpressions_0_0= ruleAndExpressionRule ) )
            // InternalMachineLearningLanguage.g:2206:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            {
            // InternalMachineLearningLanguage.g:2206:4: (lv_subExpressions_0_0= ruleAndExpressionRule )
            // InternalMachineLearningLanguage.g:2207:5: lv_subExpressions_0_0= ruleAndExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_58);
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

            // InternalMachineLearningLanguage.g:2224:3: (otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==59) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:2225:4: otherlv_1= 'XOR' ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,59,FOLLOW_56); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getXorExpressionRuleAccess().getXORKeyword_1_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:2229:4: ( (lv_subExpressions_2_0= ruleAndExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:2230:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:2230:5: (lv_subExpressions_2_0= ruleAndExpressionRule )
            	    // InternalMachineLearningLanguage.g:2231:6: lv_subExpressions_2_0= ruleAndExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXorExpressionRuleAccess().getSubExpressionsAndExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_58);
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
            	    break loop34;
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
    // InternalMachineLearningLanguage.g:2253:1: entryRuleAndExpressionRule returns [EObject current=null] : iv_ruleAndExpressionRule= ruleAndExpressionRule EOF ;
    public final EObject entryRuleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:2253:58: (iv_ruleAndExpressionRule= ruleAndExpressionRule EOF )
            // InternalMachineLearningLanguage.g:2254:2: iv_ruleAndExpressionRule= ruleAndExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:2260:1: ruleAndExpressionRule returns [EObject current=null] : ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) ;
    public final EObject ruleAndExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_subExpressions_0_0 = null;

        EObject lv_subExpressions_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2266:2: ( ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* ) )
            // InternalMachineLearningLanguage.g:2267:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            {
            // InternalMachineLearningLanguage.g:2267:2: ( ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )* )
            // InternalMachineLearningLanguage.g:2268:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) ) (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            {
            // InternalMachineLearningLanguage.g:2268:3: ( (lv_subExpressions_0_0= ruleNotExpressionRule ) )
            // InternalMachineLearningLanguage.g:2269:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            {
            // InternalMachineLearningLanguage.g:2269:4: (lv_subExpressions_0_0= ruleNotExpressionRule )
            // InternalMachineLearningLanguage.g:2270:5: lv_subExpressions_0_0= ruleNotExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_59);
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

            // InternalMachineLearningLanguage.g:2287:3: (otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==60) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:2288:4: otherlv_1= 'AND' ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    {
            	    otherlv_1=(Token)match(input,60,FOLLOW_56); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getAndExpressionRuleAccess().getANDKeyword_1_0());
            	      			
            	    }
            	    // InternalMachineLearningLanguage.g:2292:4: ( (lv_subExpressions_2_0= ruleNotExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:2293:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:2293:5: (lv_subExpressions_2_0= ruleNotExpressionRule )
            	    // InternalMachineLearningLanguage.g:2294:6: lv_subExpressions_2_0= ruleNotExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionRuleAccess().getSubExpressionsNotExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_59);
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
            	    break loop35;
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
    // InternalMachineLearningLanguage.g:2316:1: entryRuleNotExpressionRule returns [EObject current=null] : iv_ruleNotExpressionRule= ruleNotExpressionRule EOF ;
    public final EObject entryRuleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:2316:58: (iv_ruleNotExpressionRule= ruleNotExpressionRule EOF )
            // InternalMachineLearningLanguage.g:2317:2: iv_ruleNotExpressionRule= ruleNotExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:2323:1: ruleNotExpressionRule returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) ;
    public final EObject ruleNotExpressionRule() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_operand_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2329:2: ( ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) ) )
            // InternalMachineLearningLanguage.g:2330:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            {
            // InternalMachineLearningLanguage.g:2330:2: ( ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) ) )
            // InternalMachineLearningLanguage.g:2331:3: ( (lv_negated_0_0= '!' ) )? ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            {
            // InternalMachineLearningLanguage.g:2331:3: ( (lv_negated_0_0= '!' ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==61) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2332:4: (lv_negated_0_0= '!' )
                    {
                    // InternalMachineLearningLanguage.g:2332:4: (lv_negated_0_0= '!' )
                    // InternalMachineLearningLanguage.g:2333:5: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,61,FOLLOW_56); if (state.failed) return current;
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

            // InternalMachineLearningLanguage.g:2345:3: ( (lv_operand_1_0= ruleComparisonExpressionRule ) )
            // InternalMachineLearningLanguage.g:2346:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            {
            // InternalMachineLearningLanguage.g:2346:4: (lv_operand_1_0= ruleComparisonExpressionRule )
            // InternalMachineLearningLanguage.g:2347:5: lv_operand_1_0= ruleComparisonExpressionRule
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
    // InternalMachineLearningLanguage.g:2368:1: entryRuleComparisonExpressionRule returns [EObject current=null] : iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF ;
    public final EObject entryRuleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:2368:65: (iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF )
            // InternalMachineLearningLanguage.g:2369:2: iv_ruleComparisonExpressionRule= ruleComparisonExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:2375:1: ruleComparisonExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) ;
    public final EObject ruleComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        EObject lv_comparison_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2381:2: ( ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* ) )
            // InternalMachineLearningLanguage.g:2382:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            {
            // InternalMachineLearningLanguage.g:2382:2: ( ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )* )
            // InternalMachineLearningLanguage.g:2383:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) ) ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            {
            // InternalMachineLearningLanguage.g:2383:3: ( (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule ) )
            // InternalMachineLearningLanguage.g:2384:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalMachineLearningLanguage.g:2384:4: (lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule )
            // InternalMachineLearningLanguage.g:2385:5: lv_leftOperand_0_0= ruleAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getLeftOperandAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_60);
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

            // InternalMachineLearningLanguage.g:2402:3: ( (lv_comparison_1_0= rulePartialComparisonExpressionRule ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=84 && LA37_0<=89)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:2403:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:2403:4: (lv_comparison_1_0= rulePartialComparisonExpressionRule )
            	    // InternalMachineLearningLanguage.g:2404:5: lv_comparison_1_0= rulePartialComparisonExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getComparisonExpressionRuleAccess().getComparisonPartialComparisonExpressionRuleParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_60);
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
            	    break loop37;
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
    // InternalMachineLearningLanguage.g:2425:1: entryRulePartialComparisonExpressionRule returns [EObject current=null] : iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF ;
    public final EObject entryRulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialComparisonExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:2425:72: (iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF )
            // InternalMachineLearningLanguage.g:2426:2: iv_rulePartialComparisonExpressionRule= rulePartialComparisonExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:2432:1: rulePartialComparisonExpressionRule returns [EObject current=null] : ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) ;
    public final EObject rulePartialComparisonExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2438:2: ( ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) ) )
            // InternalMachineLearningLanguage.g:2439:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            {
            // InternalMachineLearningLanguage.g:2439:2: ( ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) ) )
            // InternalMachineLearningLanguage.g:2440:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) ) ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            {
            // InternalMachineLearningLanguage.g:2440:3: ( (lv_operator_0_0= ruleComparisonOperatorRule ) )
            // InternalMachineLearningLanguage.g:2441:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            {
            // InternalMachineLearningLanguage.g:2441:4: (lv_operator_0_0= ruleComparisonOperatorRule )
            // InternalMachineLearningLanguage.g:2442:5: lv_operator_0_0= ruleComparisonOperatorRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPartialComparisonExpressionRuleAccess().getOperatorComparisonOperatorRuleEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_56);
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

            // InternalMachineLearningLanguage.g:2459:3: ( (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule ) )
            // InternalMachineLearningLanguage.g:2460:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            {
            // InternalMachineLearningLanguage.g:2460:4: (lv_subExpression_1_0= ruleAddOrSubtractExpressionRule )
            // InternalMachineLearningLanguage.g:2461:5: lv_subExpression_1_0= ruleAddOrSubtractExpressionRule
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
    // InternalMachineLearningLanguage.g:2482:1: entryRuleAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddOrSubtractExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:2482:68: (iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF )
            // InternalMachineLearningLanguage.g:2483:2: iv_ruleAddOrSubtractExpressionRule= ruleAddOrSubtractExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:2489:1: ruleAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) ;
    public final EObject ruleAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2495:2: ( ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* ) )
            // InternalMachineLearningLanguage.g:2496:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            {
            // InternalMachineLearningLanguage.g:2496:2: ( ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )* )
            // InternalMachineLearningLanguage.g:2497:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) ) ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            {
            // InternalMachineLearningLanguage.g:2497:3: ( (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule ) )
            // InternalMachineLearningLanguage.g:2498:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            {
            // InternalMachineLearningLanguage.g:2498:4: (lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule )
            // InternalMachineLearningLanguage.g:2499:5: lv_leftOperand_0_0= ruleMultiplyDivideModuloExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getLeftOperandMultiplyDivideModuloExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_61);
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

            // InternalMachineLearningLanguage.g:2516:3: ( ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=90 && LA38_0<=91)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:2517:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) ) ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    {
            	    // InternalMachineLearningLanguage.g:2517:4: ( (lv_operators_1_0= ruleAddOrSubtractOperatorRule ) )
            	    // InternalMachineLearningLanguage.g:2518:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalMachineLearningLanguage.g:2518:5: (lv_operators_1_0= ruleAddOrSubtractOperatorRule )
            	    // InternalMachineLearningLanguage.g:2519:6: lv_operators_1_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_56);
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

            	    // InternalMachineLearningLanguage.g:2536:4: ( (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:2537:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:2537:5: (lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule )
            	    // InternalMachineLearningLanguage.g:2538:6: lv_operands_2_0= ruleMultiplyDivideModuloExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAddOrSubtractExpressionRuleAccess().getOperandsMultiplyDivideModuloExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_61);
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
            	    break loop38;
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
    // InternalMachineLearningLanguage.g:2560:1: entryRuleMultiplyDivideModuloExpressionRule returns [EObject current=null] : iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF ;
    public final EObject entryRuleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideModuloExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:2560:75: (iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF )
            // InternalMachineLearningLanguage.g:2561:2: iv_ruleMultiplyDivideModuloExpressionRule= ruleMultiplyDivideModuloExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:2567:1: ruleMultiplyDivideModuloExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) ;
    public final EObject ruleMultiplyDivideModuloExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_leftOperand_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2573:2: ( ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* ) )
            // InternalMachineLearningLanguage.g:2574:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            {
            // InternalMachineLearningLanguage.g:2574:2: ( ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )* )
            // InternalMachineLearningLanguage.g:2575:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) ) ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            {
            // InternalMachineLearningLanguage.g:2575:3: ( (lv_leftOperand_0_0= rulePowerOfExpressionRule ) )
            // InternalMachineLearningLanguage.g:2576:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            {
            // InternalMachineLearningLanguage.g:2576:4: (lv_leftOperand_0_0= rulePowerOfExpressionRule )
            // InternalMachineLearningLanguage.g:2577:5: lv_leftOperand_0_0= rulePowerOfExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getLeftOperandPowerOfExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_62);
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

            // InternalMachineLearningLanguage.g:2594:3: ( ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=92 && LA39_0<=94)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:2595:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) ) ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    {
            	    // InternalMachineLearningLanguage.g:2595:4: ( (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule ) )
            	    // InternalMachineLearningLanguage.g:2596:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    {
            	    // InternalMachineLearningLanguage.g:2596:5: (lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule )
            	    // InternalMachineLearningLanguage.g:2597:6: lv_operators_1_0= ruleMultiplyDivideModuloOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperatorsMultiplyDivideModuloOperatorRuleEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_56);
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

            	    // InternalMachineLearningLanguage.g:2614:4: ( (lv_operands_2_0= rulePowerOfExpressionRule ) )
            	    // InternalMachineLearningLanguage.g:2615:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    {
            	    // InternalMachineLearningLanguage.g:2615:5: (lv_operands_2_0= rulePowerOfExpressionRule )
            	    // InternalMachineLearningLanguage.g:2616:6: lv_operands_2_0= rulePowerOfExpressionRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplyDivideModuloExpressionRuleAccess().getOperandsPowerOfExpressionRuleParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_62);
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
            	    break loop39;
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
    // InternalMachineLearningLanguage.g:2638:1: entryRulePowerOfExpressionRule returns [EObject current=null] : iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF ;
    public final EObject entryRulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerOfExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:2638:62: (iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF )
            // InternalMachineLearningLanguage.g:2639:2: iv_rulePowerOfExpressionRule= rulePowerOfExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:2645:1: rulePowerOfExpressionRule returns [EObject current=null] : ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) ;
    public final EObject rulePowerOfExpressionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_leftOperand_0_0 = null;

        EObject lv_rightOperand_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2651:2: ( ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? ) )
            // InternalMachineLearningLanguage.g:2652:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            {
            // InternalMachineLearningLanguage.g:2652:2: ( ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )? )
            // InternalMachineLearningLanguage.g:2653:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) ) (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            {
            // InternalMachineLearningLanguage.g:2653:3: ( (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule ) )
            // InternalMachineLearningLanguage.g:2654:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            {
            // InternalMachineLearningLanguage.g:2654:4: (lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule )
            // InternalMachineLearningLanguage.g:2655:5: lv_leftOperand_0_0= ruleUnaryAddOrSubtractExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPowerOfExpressionRuleAccess().getLeftOperandUnaryAddOrSubtractExpressionRuleParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_63);
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

            // InternalMachineLearningLanguage.g:2672:3: (otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==62) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2673:4: otherlv_1= '^' ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    {
                    otherlv_1=(Token)match(input,62,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPowerOfExpressionRuleAccess().getCircumflexAccentKeyword_1_0());
                      			
                    }
                    // InternalMachineLearningLanguage.g:2677:4: ( (lv_rightOperand_2_0= rulePowerOfExpressionRule ) )
                    // InternalMachineLearningLanguage.g:2678:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    {
                    // InternalMachineLearningLanguage.g:2678:5: (lv_rightOperand_2_0= rulePowerOfExpressionRule )
                    // InternalMachineLearningLanguage.g:2679:6: lv_rightOperand_2_0= rulePowerOfExpressionRule
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
    // InternalMachineLearningLanguage.g:2701:1: entryRuleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF ;
    public final EObject entryRuleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryAddOrSubtractExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:2701:73: (iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF )
            // InternalMachineLearningLanguage.g:2702:2: iv_ruleUnaryAddOrSubtractExpressionRule= ruleUnaryAddOrSubtractExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:2708:1: ruleUnaryAddOrSubtractExpressionRule returns [EObject current=null] : ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) ) ;
    public final EObject ruleUnaryAddOrSubtractExpressionRule() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operators_0_0 = null;

        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2714:2: ( ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) ) )
            // InternalMachineLearningLanguage.g:2715:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) )
            {
            // InternalMachineLearningLanguage.g:2715:2: ( ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) ) )
            // InternalMachineLearningLanguage.g:2716:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )* ( (lv_subExpression_1_0= ruleReadExpressionRule ) )
            {
            // InternalMachineLearningLanguage.g:2716:3: ( (lv_operators_0_0= ruleAddOrSubtractOperatorRule ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=90 && LA41_0<=91)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:2717:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    {
            	    // InternalMachineLearningLanguage.g:2717:4: (lv_operators_0_0= ruleAddOrSubtractOperatorRule )
            	    // InternalMachineLearningLanguage.g:2718:5: lv_operators_0_0= ruleAddOrSubtractOperatorRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUnaryAddOrSubtractExpressionRuleAccess().getOperatorsAddOrSubtractOperatorRuleEnumRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_64);
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
            	    break loop41;
                }
            } while (true);

            // InternalMachineLearningLanguage.g:2735:3: ( (lv_subExpression_1_0= ruleReadExpressionRule ) )
            // InternalMachineLearningLanguage.g:2736:4: (lv_subExpression_1_0= ruleReadExpressionRule )
            {
            // InternalMachineLearningLanguage.g:2736:4: (lv_subExpression_1_0= ruleReadExpressionRule )
            // InternalMachineLearningLanguage.g:2737:5: lv_subExpression_1_0= ruleReadExpressionRule
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
    // InternalMachineLearningLanguage.g:2758:1: entryRuleReadExpressionRule returns [EObject current=null] : iv_ruleReadExpressionRule= ruleReadExpressionRule EOF ;
    public final EObject entryRuleReadExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReadExpressionRule = null;


        try {
            // InternalMachineLearningLanguage.g:2758:59: (iv_ruleReadExpressionRule= ruleReadExpressionRule EOF )
            // InternalMachineLearningLanguage.g:2759:2: iv_ruleReadExpressionRule= ruleReadExpressionRule EOF
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
    // InternalMachineLearningLanguage.g:2765:1: ruleReadExpressionRule returns [EObject current=null] : (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) ;
    public final EObject ruleReadExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayRule_0 = null;

        EObject this_CallRule_1 = null;

        EObject this_LiteralRule_2 = null;

        EObject this_ParanthesesRule_3 = null;

        EObject this_ReferenceRule_4 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2771:2: ( (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule ) )
            // InternalMachineLearningLanguage.g:2772:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            {
            // InternalMachineLearningLanguage.g:2772:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )
            int alt42=5;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2773:3: this_ArrayRule_0= ruleArrayRule
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
                    // InternalMachineLearningLanguage.g:2785:3: this_CallRule_1= ruleCallRule
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
                    // InternalMachineLearningLanguage.g:2797:3: this_LiteralRule_2= ruleLiteralRule
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
                    // InternalMachineLearningLanguage.g:2809:3: this_ParanthesesRule_3= ruleParanthesesRule
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
                    // InternalMachineLearningLanguage.g:2821:3: this_ReferenceRule_4= ruleReferenceRule
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
    // InternalMachineLearningLanguage.g:2836:1: entryRuleArrayRule returns [EObject current=null] : iv_ruleArrayRule= ruleArrayRule EOF ;
    public final EObject entryRuleArrayRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRule = null;


        try {
            // InternalMachineLearningLanguage.g:2836:50: (iv_ruleArrayRule= ruleArrayRule EOF )
            // InternalMachineLearningLanguage.g:2837:2: iv_ruleArrayRule= ruleArrayRule EOF
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
    // InternalMachineLearningLanguage.g:2843:1: ruleArrayRule returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2849:2: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' ) )
            // InternalMachineLearningLanguage.g:2850:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' )
            {
            // InternalMachineLearningLanguage.g:2850:2: ( () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']' )
            // InternalMachineLearningLanguage.g:2851:3: () otherlv_1= '[' ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )? otherlv_5= ']'
            {
            // InternalMachineLearningLanguage.g:2851:3: ()
            // InternalMachineLearningLanguage.g:2852:4: 
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

            otherlv_1=(Token)match(input,32,FOLLOW_65); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArrayRuleAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:2865:3: ( ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )* )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_STRING && LA44_0<=RULE_ID)||LA44_0==32||(LA44_0>=44 && LA44_0<=45)||LA44_0==56||(LA44_0>=65 && LA44_0<=66)||(LA44_0>=68 && LA44_0<=69)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalMachineLearningLanguage.g:2866:4: ( (lv_values_2_0= ruleReadExpressionRule ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )*
                    {
                    // InternalMachineLearningLanguage.g:2866:4: ( (lv_values_2_0= ruleReadExpressionRule ) )
                    // InternalMachineLearningLanguage.g:2867:5: (lv_values_2_0= ruleReadExpressionRule )
                    {
                    // InternalMachineLearningLanguage.g:2867:5: (lv_values_2_0= ruleReadExpressionRule )
                    // InternalMachineLearningLanguage.g:2868:6: lv_values_2_0= ruleReadExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesReadExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_25);
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

                    // InternalMachineLearningLanguage.g:2885:4: (otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==28) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // InternalMachineLearningLanguage.g:2886:5: otherlv_3= ',' ( (lv_values_4_0= ruleReadExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,28,FOLLOW_45); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getArrayRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalMachineLearningLanguage.g:2890:5: ( (lv_values_4_0= ruleReadExpressionRule ) )
                    	    // InternalMachineLearningLanguage.g:2891:6: (lv_values_4_0= ruleReadExpressionRule )
                    	    {
                    	    // InternalMachineLearningLanguage.g:2891:6: (lv_values_4_0= ruleReadExpressionRule )
                    	    // InternalMachineLearningLanguage.g:2892:7: lv_values_4_0= ruleReadExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getArrayRuleAccess().getValuesReadExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_25);
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
                    	    break loop43;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:2919:1: entryRuleParanthesesRule returns [EObject current=null] : iv_ruleParanthesesRule= ruleParanthesesRule EOF ;
    public final EObject entryRuleParanthesesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesesRule = null;


        try {
            // InternalMachineLearningLanguage.g:2919:56: (iv_ruleParanthesesRule= ruleParanthesesRule EOF )
            // InternalMachineLearningLanguage.g:2920:2: iv_ruleParanthesesRule= ruleParanthesesRule EOF
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
    // InternalMachineLearningLanguage.g:2926:1: ruleParanthesesRule returns [EObject current=null] : (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) ;
    public final EObject ruleParanthesesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_subExpression_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2932:2: ( (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' ) )
            // InternalMachineLearningLanguage.g:2933:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            {
            // InternalMachineLearningLanguage.g:2933:2: (otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')' )
            // InternalMachineLearningLanguage.g:2934:3: otherlv_0= '(' ( (lv_subExpression_1_0= ruleExpressionRule ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParanthesesRuleAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:2938:3: ( (lv_subExpression_1_0= ruleExpressionRule ) )
            // InternalMachineLearningLanguage.g:2939:4: (lv_subExpression_1_0= ruleExpressionRule )
            {
            // InternalMachineLearningLanguage.g:2939:4: (lv_subExpression_1_0= ruleExpressionRule )
            // InternalMachineLearningLanguage.g:2940:5: lv_subExpression_1_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParanthesesRuleAccess().getSubExpressionExpressionRuleParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_66);
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

            otherlv_2=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:2965:1: entryRuleCallRule returns [EObject current=null] : iv_ruleCallRule= ruleCallRule EOF ;
    public final EObject entryRuleCallRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallRule = null;


        try {
            // InternalMachineLearningLanguage.g:2965:49: (iv_ruleCallRule= ruleCallRule EOF )
            // InternalMachineLearningLanguage.g:2966:2: iv_ruleCallRule= ruleCallRule EOF
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
    // InternalMachineLearningLanguage.g:2972:1: ruleCallRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleCallRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_parameters_4_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:2978:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' ) )
            // InternalMachineLearningLanguage.g:2979:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            {
            // InternalMachineLearningLanguage.g:2979:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')' )
            // InternalMachineLearningLanguage.g:2980:3: ( ( ruleQualifiedName ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )? otherlv_5= ')'
            {
            // InternalMachineLearningLanguage.g:2980:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:2981:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:2981:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:2982:5: ruleQualifiedName
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
            pushFollow(FOLLOW_53);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,56,FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallRuleAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:3003:3: ( ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )* )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_STRING && LA46_0<=RULE_ID)||LA46_0==32||(LA46_0>=44 && LA46_0<=45)||LA46_0==56||LA46_0==61||(LA46_0>=65 && LA46_0<=66)||(LA46_0>=68 && LA46_0<=69)||(LA46_0>=90 && LA46_0<=91)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalMachineLearningLanguage.g:3004:4: ( (lv_parameters_2_0= ruleExpressionRule ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    {
                    // InternalMachineLearningLanguage.g:3004:4: ( (lv_parameters_2_0= ruleExpressionRule ) )
                    // InternalMachineLearningLanguage.g:3005:5: (lv_parameters_2_0= ruleExpressionRule )
                    {
                    // InternalMachineLearningLanguage.g:3005:5: (lv_parameters_2_0= ruleExpressionRule )
                    // InternalMachineLearningLanguage.g:3006:6: lv_parameters_2_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_55);
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

                    // InternalMachineLearningLanguage.g:3023:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==28) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalMachineLearningLanguage.g:3024:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,28,FOLLOW_56); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getCallRuleAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalMachineLearningLanguage.g:3028:5: ( (lv_parameters_4_0= ruleExpressionRule ) )
                    	    // InternalMachineLearningLanguage.g:3029:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    {
                    	    // InternalMachineLearningLanguage.g:3029:6: (lv_parameters_4_0= ruleExpressionRule )
                    	    // InternalMachineLearningLanguage.g:3030:7: lv_parameters_4_0= ruleExpressionRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCallRuleAccess().getParametersExpressionRuleParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_55);
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
                    	    break loop45;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleSelfReferenceRule"
    // InternalMachineLearningLanguage.g:3057:1: entryRuleSelfReferenceRule returns [EObject current=null] : iv_ruleSelfReferenceRule= ruleSelfReferenceRule EOF ;
    public final EObject entryRuleSelfReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:3057:58: (iv_ruleSelfReferenceRule= ruleSelfReferenceRule EOF )
            // InternalMachineLearningLanguage.g:3058:2: iv_ruleSelfReferenceRule= ruleSelfReferenceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfReferenceRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSelfReferenceRule=ruleSelfReferenceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfReferenceRule; 
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
    // $ANTLR end "entryRuleSelfReferenceRule"


    // $ANTLR start "ruleSelfReferenceRule"
    // InternalMachineLearningLanguage.g:3064:1: ruleSelfReferenceRule returns [EObject current=null] : ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'value' ) ) ;
    public final EObject ruleSelfReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3070:2: ( ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'value' ) ) )
            // InternalMachineLearningLanguage.g:3071:2: ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'value' ) )
            {
            // InternalMachineLearningLanguage.g:3071:2: ( ( () otherlv_1= 'self' ) | ( () otherlv_3= 'value' ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==63) ) {
                alt47=1;
            }
            else if ( (LA47_0==64) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalMachineLearningLanguage.g:3072:3: ( () otherlv_1= 'self' )
                    {
                    // InternalMachineLearningLanguage.g:3072:3: ( () otherlv_1= 'self' )
                    // InternalMachineLearningLanguage.g:3073:4: () otherlv_1= 'self'
                    {
                    // InternalMachineLearningLanguage.g:3073:4: ()
                    // InternalMachineLearningLanguage.g:3074:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSelfReferenceRuleAccess().getSelfKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:3089:3: ( () otherlv_3= 'value' )
                    {
                    // InternalMachineLearningLanguage.g:3089:3: ( () otherlv_3= 'value' )
                    // InternalMachineLearningLanguage.g:3090:4: () otherlv_3= 'value'
                    {
                    // InternalMachineLearningLanguage.g:3090:4: ()
                    // InternalMachineLearningLanguage.g:3091:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getSelfReferenceRuleAccess().getSelfReferenceAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_3=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getSelfReferenceRuleAccess().getValueKeyword_1_1());
                      			
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
    // $ANTLR end "ruleSelfReferenceRule"


    // $ANTLR start "entryRuleValuelDefinitionReferenceRule"
    // InternalMachineLearningLanguage.g:3109:1: entryRuleValuelDefinitionReferenceRule returns [EObject current=null] : iv_ruleValuelDefinitionReferenceRule= ruleValuelDefinitionReferenceRule EOF ;
    public final EObject entryRuleValuelDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValuelDefinitionReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:3109:70: (iv_ruleValuelDefinitionReferenceRule= ruleValuelDefinitionReferenceRule EOF )
            // InternalMachineLearningLanguage.g:3110:2: iv_ruleValuelDefinitionReferenceRule= ruleValuelDefinitionReferenceRule EOF
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
    // InternalMachineLearningLanguage.g:3116:1: ruleValuelDefinitionReferenceRule returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleValuelDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3122:2: ( ( ( ruleQualifiedName ) ) )
            // InternalMachineLearningLanguage.g:3123:2: ( ( ruleQualifiedName ) )
            {
            // InternalMachineLearningLanguage.g:3123:2: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:3124:3: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:3124:3: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:3125:4: ruleQualifiedName
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
    // InternalMachineLearningLanguage.g:3145:1: entryRuleTypeDefinitionReferenceRule returns [EObject current=null] : iv_ruleTypeDefinitionReferenceRule= ruleTypeDefinitionReferenceRule EOF ;
    public final EObject entryRuleTypeDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDefinitionReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:3145:68: (iv_ruleTypeDefinitionReferenceRule= ruleTypeDefinitionReferenceRule EOF )
            // InternalMachineLearningLanguage.g:3146:2: iv_ruleTypeDefinitionReferenceRule= ruleTypeDefinitionReferenceRule EOF
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
    // InternalMachineLearningLanguage.g:3152:1: ruleTypeDefinitionReferenceRule returns [EObject current=null] : (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule ) ;
    public final EObject ruleTypeDefinitionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject this_BaseDataReferenceRule_0 = null;

        EObject this_StructuredDataDescriptionReferenceRule_1 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3158:2: ( (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule ) )
            // InternalMachineLearningLanguage.g:3159:2: (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule )
            {
            // InternalMachineLearningLanguage.g:3159:2: (this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule | this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==65) ) {
                alt48=1;
            }
            else if ( (LA48_0==66) ) {
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
                    // InternalMachineLearningLanguage.g:3160:3: this_BaseDataReferenceRule_0= ruleBaseDataReferenceRule
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
                    // InternalMachineLearningLanguage.g:3172:3: this_StructuredDataDescriptionReferenceRule_1= ruleStructuredDataDescriptionReferenceRule
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
    // InternalMachineLearningLanguage.g:3187:1: entryRuleBaseDataReferenceRule returns [EObject current=null] : iv_ruleBaseDataReferenceRule= ruleBaseDataReferenceRule EOF ;
    public final EObject entryRuleBaseDataReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseDataReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:3187:62: (iv_ruleBaseDataReferenceRule= ruleBaseDataReferenceRule EOF )
            // InternalMachineLearningLanguage.g:3188:2: iv_ruleBaseDataReferenceRule= ruleBaseDataReferenceRule EOF
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
    // InternalMachineLearningLanguage.g:3194:1: ruleBaseDataReferenceRule returns [EObject current=null] : (otherlv_0= 'data' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleBaseDataReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3200:2: ( (otherlv_0= 'data' ( ( ruleQualifiedName ) ) ) )
            // InternalMachineLearningLanguage.g:3201:2: (otherlv_0= 'data' ( ( ruleQualifiedName ) ) )
            {
            // InternalMachineLearningLanguage.g:3201:2: (otherlv_0= 'data' ( ( ruleQualifiedName ) ) )
            // InternalMachineLearningLanguage.g:3202:3: otherlv_0= 'data' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,65,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBaseDataReferenceRuleAccess().getDataKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:3206:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:3207:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:3207:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:3208:5: ruleQualifiedName
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
    // InternalMachineLearningLanguage.g:3229:1: entryRuleStructuredDataDescriptionReferenceRule returns [EObject current=null] : iv_ruleStructuredDataDescriptionReferenceRule= ruleStructuredDataDescriptionReferenceRule EOF ;
    public final EObject entryRuleStructuredDataDescriptionReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataDescriptionReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:3229:79: (iv_ruleStructuredDataDescriptionReferenceRule= ruleStructuredDataDescriptionReferenceRule EOF )
            // InternalMachineLearningLanguage.g:3230:2: iv_ruleStructuredDataDescriptionReferenceRule= ruleStructuredDataDescriptionReferenceRule EOF
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
    // InternalMachineLearningLanguage.g:3236:1: ruleStructuredDataDescriptionReferenceRule returns [EObject current=null] : (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleStructuredDataDescriptionReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3242:2: ( (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) )
            // InternalMachineLearningLanguage.g:3243:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            {
            // InternalMachineLearningLanguage.g:3243:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            // InternalMachineLearningLanguage.g:3244:3: otherlv_0= 'instance' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,66,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStructuredDataDescriptionReferenceRuleAccess().getInstanceKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:3248:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:3249:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:3249:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:3250:5: ruleQualifiedName
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


    // $ANTLR start "entryRuleInstanceLiteralRule"
    // InternalMachineLearningLanguage.g:3271:1: entryRuleInstanceLiteralRule returns [EObject current=null] : iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF ;
    public final EObject entryRuleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:3271:60: (iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF )
            // InternalMachineLearningLanguage.g:3272:2: iv_ruleInstanceLiteralRule= ruleInstanceLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:3278:1: ruleInstanceLiteralRule returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' ) ;
    public final EObject ruleInstanceLiteralRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3284:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' ) )
            // InternalMachineLearningLanguage.g:3285:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )
            {
            // InternalMachineLearningLanguage.g:3285:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}' )
            // InternalMachineLearningLanguage.g:3286:3: ( ( ruleQualifiedName ) ) otherlv_1= '{' ( (lv_attributes_2_0= ruleAttributeRule ) )* otherlv_3= '}'
            {
            // InternalMachineLearningLanguage.g:3286:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:3287:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:3287:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:3288:5: ruleQualifiedName
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

            otherlv_1=(Token)match(input,16,FOLLOW_67); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInstanceLiteralRuleAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:3309:3: ( (lv_attributes_2_0= ruleAttributeRule ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=RULE_QUOTED_ID && LA49_0<=RULE_ID)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:3310:4: (lv_attributes_2_0= ruleAttributeRule )
            	    {
            	    // InternalMachineLearningLanguage.g:3310:4: (lv_attributes_2_0= ruleAttributeRule )
            	    // InternalMachineLearningLanguage.g:3311:5: lv_attributes_2_0= ruleAttributeRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getInstanceLiteralRuleAccess().getAttributesAttributeRuleParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_67);
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
            	    break loop49;
                }
            } while (true);

            otherlv_3=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:3336:1: entryRuleAttributeRule returns [EObject current=null] : iv_ruleAttributeRule= ruleAttributeRule EOF ;
    public final EObject entryRuleAttributeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeRule = null;


        try {
            // InternalMachineLearningLanguage.g:3336:54: (iv_ruleAttributeRule= ruleAttributeRule EOF )
            // InternalMachineLearningLanguage.g:3337:2: iv_ruleAttributeRule= ruleAttributeRule EOF
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
    // InternalMachineLearningLanguage.g:3343:1: ruleAttributeRule returns [EObject current=null] : ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttributeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3349:2: ( ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' ) )
            // InternalMachineLearningLanguage.g:3350:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' )
            {
            // InternalMachineLearningLanguage.g:3350:2: ( ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';' )
            // InternalMachineLearningLanguage.g:3351:3: ( ( ruleStringOrId ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpressionRule ) ) otherlv_3= ';'
            {
            // InternalMachineLearningLanguage.g:3351:3: ( ( ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:3352:4: ( ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:3352:4: ( ruleStringOrId )
            // InternalMachineLearningLanguage.g:3353:5: ruleStringOrId
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
            pushFollow(FOLLOW_68);
            ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,67,FOLLOW_56); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttributeRuleAccess().getColonEqualsSignKeyword_1());
              		
            }
            // InternalMachineLearningLanguage.g:3374:3: ( (lv_value_2_0= ruleExpressionRule ) )
            // InternalMachineLearningLanguage.g:3375:4: (lv_value_2_0= ruleExpressionRule )
            {
            // InternalMachineLearningLanguage.g:3375:4: (lv_value_2_0= ruleExpressionRule )
            // InternalMachineLearningLanguage.g:3376:5: lv_value_2_0= ruleExpressionRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeRuleAccess().getValueExpressionRuleParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_14);
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

            otherlv_3=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:3401:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:3401:58: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // InternalMachineLearningLanguage.g:3402:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:3408:1: ruleNumberLiteralRule returns [EObject current=null] : (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_RealLiteralRule_0 = null;

        EObject this_IntegerLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3414:2: ( (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule ) )
            // InternalMachineLearningLanguage.g:3415:2: (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            {
            // InternalMachineLearningLanguage.g:3415:2: (this_RealLiteralRule_0= ruleRealLiteralRule | this_IntegerLiteralRule_1= ruleIntegerLiteralRule )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_DOUBLE) ) {
                alt50=1;
            }
            else if ( (LA50_0==RULE_INT) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalMachineLearningLanguage.g:3416:3: this_RealLiteralRule_0= ruleRealLiteralRule
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
                    // InternalMachineLearningLanguage.g:3428:3: this_IntegerLiteralRule_1= ruleIntegerLiteralRule
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
    // InternalMachineLearningLanguage.g:3443:1: entryRuleRealLiteralRule returns [EObject current=null] : iv_ruleRealLiteralRule= ruleRealLiteralRule EOF ;
    public final EObject entryRuleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:3443:56: (iv_ruleRealLiteralRule= ruleRealLiteralRule EOF )
            // InternalMachineLearningLanguage.g:3444:2: iv_ruleRealLiteralRule= ruleRealLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:3450:1: ruleRealLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3456:2: ( ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalMachineLearningLanguage.g:3457:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalMachineLearningLanguage.g:3457:2: ( ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalMachineLearningLanguage.g:3458:3: ( (lv_literal_0_0= RULE_DOUBLE ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalMachineLearningLanguage.g:3458:3: ( (lv_literal_0_0= RULE_DOUBLE ) )
            // InternalMachineLearningLanguage.g:3459:4: (lv_literal_0_0= RULE_DOUBLE )
            {
            // InternalMachineLearningLanguage.g:3459:4: (lv_literal_0_0= RULE_DOUBLE )
            // InternalMachineLearningLanguage.g:3460:5: lv_literal_0_0= RULE_DOUBLE
            {
            lv_literal_0_0=(Token)match(input,RULE_DOUBLE,FOLLOW_69); if (state.failed) return current;
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

            // InternalMachineLearningLanguage.g:3476:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=95 && LA51_0<=114)) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalMachineLearningLanguage.g:3477:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalMachineLearningLanguage.g:3477:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalMachineLearningLanguage.g:3478:5: lv_factor_1_0= ruleFactorRule
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
    // InternalMachineLearningLanguage.g:3499:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:3499:59: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // InternalMachineLearningLanguage.g:3500:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:3506:1: ruleIntegerLiteralRule returns [EObject current=null] : ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;
        Enumerator lv_factor_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3512:2: ( ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? ) )
            // InternalMachineLearningLanguage.g:3513:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            {
            // InternalMachineLearningLanguage.g:3513:2: ( ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )? )
            // InternalMachineLearningLanguage.g:3514:3: ( (lv_literal_0_0= RULE_INT ) ) ( (lv_factor_1_0= ruleFactorRule ) )?
            {
            // InternalMachineLearningLanguage.g:3514:3: ( (lv_literal_0_0= RULE_INT ) )
            // InternalMachineLearningLanguage.g:3515:4: (lv_literal_0_0= RULE_INT )
            {
            // InternalMachineLearningLanguage.g:3515:4: (lv_literal_0_0= RULE_INT )
            // InternalMachineLearningLanguage.g:3516:5: lv_literal_0_0= RULE_INT
            {
            lv_literal_0_0=(Token)match(input,RULE_INT,FOLLOW_69); if (state.failed) return current;
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

            // InternalMachineLearningLanguage.g:3532:3: ( (lv_factor_1_0= ruleFactorRule ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=95 && LA52_0<=114)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalMachineLearningLanguage.g:3533:4: (lv_factor_1_0= ruleFactorRule )
                    {
                    // InternalMachineLearningLanguage.g:3533:4: (lv_factor_1_0= ruleFactorRule )
                    // InternalMachineLearningLanguage.g:3534:5: lv_factor_1_0= ruleFactorRule
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
    // InternalMachineLearningLanguage.g:3555:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:3555:58: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // InternalMachineLearningLanguage.g:3556:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:3562:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_literal_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_0_0=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3568:2: ( ( (lv_literal_0_0= RULE_STRING ) ) )
            // InternalMachineLearningLanguage.g:3569:2: ( (lv_literal_0_0= RULE_STRING ) )
            {
            // InternalMachineLearningLanguage.g:3569:2: ( (lv_literal_0_0= RULE_STRING ) )
            // InternalMachineLearningLanguage.g:3570:3: (lv_literal_0_0= RULE_STRING )
            {
            // InternalMachineLearningLanguage.g:3570:3: (lv_literal_0_0= RULE_STRING )
            // InternalMachineLearningLanguage.g:3571:4: lv_literal_0_0= RULE_STRING
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
    // InternalMachineLearningLanguage.g:3590:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // InternalMachineLearningLanguage.g:3590:59: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // InternalMachineLearningLanguage.g:3591:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
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
    // InternalMachineLearningLanguage.g:3597:1: ruleBooleanLiteralRule returns [EObject current=null] : ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_literal_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3603:2: ( ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalMachineLearningLanguage.g:3604:2: ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalMachineLearningLanguage.g:3604:2: ( () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalMachineLearningLanguage.g:3605:3: () ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalMachineLearningLanguage.g:3605:3: ()
            // InternalMachineLearningLanguage.g:3606:4: 
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

            // InternalMachineLearningLanguage.g:3615:3: ( ( (lv_literal_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==68) ) {
                alt53=1;
            }
            else if ( (LA53_0==69) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalMachineLearningLanguage.g:3616:4: ( (lv_literal_1_0= 'true' ) )
                    {
                    // InternalMachineLearningLanguage.g:3616:4: ( (lv_literal_1_0= 'true' ) )
                    // InternalMachineLearningLanguage.g:3617:5: (lv_literal_1_0= 'true' )
                    {
                    // InternalMachineLearningLanguage.g:3617:5: (lv_literal_1_0= 'true' )
                    // InternalMachineLearningLanguage.g:3618:6: lv_literal_1_0= 'true'
                    {
                    lv_literal_1_0=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
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
                    // InternalMachineLearningLanguage.g:3631:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:3640:1: entryRuleConstraintRule returns [EObject current=null] : iv_ruleConstraintRule= ruleConstraintRule EOF ;
    public final EObject entryRuleConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintRule = null;


        try {
            // InternalMachineLearningLanguage.g:3640:55: (iv_ruleConstraintRule= ruleConstraintRule EOF )
            // InternalMachineLearningLanguage.g:3641:2: iv_ruleConstraintRule= ruleConstraintRule EOF
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
    // InternalMachineLearningLanguage.g:3647:1: ruleConstraintRule returns [EObject current=null] : (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule ) ;
    public final EObject ruleConstraintRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_InstanceLiteralRule_1 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3653:2: ( (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule ) )
            // InternalMachineLearningLanguage.g:3654:2: (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule )
            {
            // InternalMachineLearningLanguage.g:3654:2: (otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule )
            // InternalMachineLearningLanguage.g:3655:3: otherlv_0= '@' this_InstanceLiteralRule_1= ruleInstanceLiteralRule
            {
            otherlv_0=(Token)match(input,70,FOLLOW_4); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:3674:1: entryRuleAttributeDefinitionRule returns [EObject current=null] : iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF ;
    public final EObject entryRuleAttributeDefinitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeDefinitionRule = null;


        try {
            // InternalMachineLearningLanguage.g:3674:64: (iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF )
            // InternalMachineLearningLanguage.g:3675:2: iv_ruleAttributeDefinitionRule= ruleAttributeDefinitionRule EOF
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
    // InternalMachineLearningLanguage.g:3681:1: ruleAttributeDefinitionRule returns [EObject current=null] : ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' ) ;
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
            // InternalMachineLearningLanguage.g:3687:2: ( ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' ) )
            // InternalMachineLearningLanguage.g:3688:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' )
            {
            // InternalMachineLearningLanguage.g:3688:2: ( ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';' )
            // InternalMachineLearningLanguage.g:3689:3: ( (lv_constraints_0_0= ruleConstraintRule ) )* ( (lv_name_1_0= ruleStringOrId ) ) otherlv_2= ':' ( (lv_optional_3_0= 'optional' ) )? ( (lv_type_4_0= ruleTypeRule ) ) (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )? otherlv_7= ';'
            {
            // InternalMachineLearningLanguage.g:3689:3: ( (lv_constraints_0_0= ruleConstraintRule ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==70) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:3690:4: (lv_constraints_0_0= ruleConstraintRule )
            	    {
            	    // InternalMachineLearningLanguage.g:3690:4: (lv_constraints_0_0= ruleConstraintRule )
            	    // InternalMachineLearningLanguage.g:3691:5: lv_constraints_0_0= ruleConstraintRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getConstraintsConstraintRuleParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_70);
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
            	    break loop54;
                }
            } while (true);

            // InternalMachineLearningLanguage.g:3708:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:3709:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:3709:4: (lv_name_1_0= ruleStringOrId )
            // InternalMachineLearningLanguage.g:3710:5: lv_name_1_0= ruleStringOrId
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getNameStringOrIdParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_71);
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

            otherlv_2=(Token)match(input,71,FOLLOW_72); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAttributeDefinitionRuleAccess().getColonKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:3731:3: ( (lv_optional_3_0= 'optional' ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==72) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalMachineLearningLanguage.g:3732:4: (lv_optional_3_0= 'optional' )
                    {
                    // InternalMachineLearningLanguage.g:3732:4: (lv_optional_3_0= 'optional' )
                    // InternalMachineLearningLanguage.g:3733:5: lv_optional_3_0= 'optional'
                    {
                    lv_optional_3_0=(Token)match(input,72,FOLLOW_72); if (state.failed) return current;
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

            // InternalMachineLearningLanguage.g:3745:3: ( (lv_type_4_0= ruleTypeRule ) )
            // InternalMachineLearningLanguage.g:3746:4: (lv_type_4_0= ruleTypeRule )
            {
            // InternalMachineLearningLanguage.g:3746:4: (lv_type_4_0= ruleTypeRule )
            // InternalMachineLearningLanguage.g:3747:5: lv_type_4_0= ruleTypeRule
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getTypeTypeRuleParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_73);
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

            // InternalMachineLearningLanguage.g:3764:3: (otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==67) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalMachineLearningLanguage.g:3765:4: otherlv_5= ':=' ( (lv_initialisation_6_0= ruleExpressionRule ) )
                    {
                    otherlv_5=(Token)match(input,67,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getAttributeDefinitionRuleAccess().getColonEqualsSignKeyword_5_0());
                      			
                    }
                    // InternalMachineLearningLanguage.g:3769:4: ( (lv_initialisation_6_0= ruleExpressionRule ) )
                    // InternalMachineLearningLanguage.g:3770:5: (lv_initialisation_6_0= ruleExpressionRule )
                    {
                    // InternalMachineLearningLanguage.g:3770:5: (lv_initialisation_6_0= ruleExpressionRule )
                    // InternalMachineLearningLanguage.g:3771:6: lv_initialisation_6_0= ruleExpressionRule
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAttributeDefinitionRuleAccess().getInitialisationExpressionRuleParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_14);
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

            otherlv_7=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:3797:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:3797:49: (iv_ruleTypeRule= ruleTypeRule EOF )
            // InternalMachineLearningLanguage.g:3798:2: iv_ruleTypeRule= ruleTypeRule EOF
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
    // InternalMachineLearningLanguage.g:3804:1: ruleTypeRule returns [EObject current=null] : (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule ) ;
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
            // InternalMachineLearningLanguage.g:3810:2: ( (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule ) )
            // InternalMachineLearningLanguage.g:3811:2: (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule )
            {
            // InternalMachineLearningLanguage.g:3811:2: (this_ArrayTypeRule_0= ruleArrayTypeRule | this_BaseTypeRule_1= ruleBaseTypeRule | this_TypeReferenceRule_2= ruleTypeReferenceRule | this_EnumReferenceRule_3= ruleEnumReferenceRule | this_ExpressionTypeRule_4= ruleExpressionTypeRule | this_LiteralTypeRule_5= ruleLiteralTypeRule | this_DataTypeRule_6= ruleDataTypeRule )
            int alt57=7;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt57=1;
                }
                break;
            case 75:
            case 77:
            case 78:
            case 79:
            case 80:
                {
                alt57=2;
                }
                break;
            case 66:
                {
                alt57=3;
                }
                break;
            case 73:
                {
                alt57=4;
                }
                break;
            case 76:
                {
                alt57=5;
                }
                break;
            case 74:
                {
                alt57=6;
                }
                break;
            case 65:
                {
                alt57=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalMachineLearningLanguage.g:3812:3: this_ArrayTypeRule_0= ruleArrayTypeRule
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
                    // InternalMachineLearningLanguage.g:3824:3: this_BaseTypeRule_1= ruleBaseTypeRule
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
                    // InternalMachineLearningLanguage.g:3836:3: this_TypeReferenceRule_2= ruleTypeReferenceRule
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
                    // InternalMachineLearningLanguage.g:3848:3: this_EnumReferenceRule_3= ruleEnumReferenceRule
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
                    // InternalMachineLearningLanguage.g:3860:3: this_ExpressionTypeRule_4= ruleExpressionTypeRule
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
                    // InternalMachineLearningLanguage.g:3872:3: this_LiteralTypeRule_5= ruleLiteralTypeRule
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
                    // InternalMachineLearningLanguage.g:3884:3: this_DataTypeRule_6= ruleDataTypeRule
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
    // InternalMachineLearningLanguage.g:3899:1: entryRuleBaseTypeRule returns [EObject current=null] : iv_ruleBaseTypeRule= ruleBaseTypeRule EOF ;
    public final EObject entryRuleBaseTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:3899:53: (iv_ruleBaseTypeRule= ruleBaseTypeRule EOF )
            // InternalMachineLearningLanguage.g:3900:2: iv_ruleBaseTypeRule= ruleBaseTypeRule EOF
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
    // InternalMachineLearningLanguage.g:3906:1: ruleBaseTypeRule returns [EObject current=null] : (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule ) ;
    public final EObject ruleBaseTypeRule() throws RecognitionException {
        EObject current = null;

        EObject this_StringTypeRule_0 = null;

        EObject this_IntTypeRule_1 = null;

        EObject this_RealTypeRule_2 = null;

        EObject this_BooleanTypeRule_3 = null;

        EObject this_VoidTypeRule_4 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3912:2: ( (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule ) )
            // InternalMachineLearningLanguage.g:3913:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule )
            {
            // InternalMachineLearningLanguage.g:3913:2: (this_StringTypeRule_0= ruleStringTypeRule | this_IntTypeRule_1= ruleIntTypeRule | this_RealTypeRule_2= ruleRealTypeRule | this_BooleanTypeRule_3= ruleBooleanTypeRule | this_VoidTypeRule_4= ruleVoidTypeRule )
            int alt58=5;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt58=1;
                }
                break;
            case 77:
                {
                alt58=2;
                }
                break;
            case 78:
                {
                alt58=3;
                }
                break;
            case 79:
                {
                alt58=4;
                }
                break;
            case 80:
                {
                alt58=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalMachineLearningLanguage.g:3914:3: this_StringTypeRule_0= ruleStringTypeRule
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
                    // InternalMachineLearningLanguage.g:3926:3: this_IntTypeRule_1= ruleIntTypeRule
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
                    // InternalMachineLearningLanguage.g:3938:3: this_RealTypeRule_2= ruleRealTypeRule
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
                    // InternalMachineLearningLanguage.g:3950:3: this_BooleanTypeRule_3= ruleBooleanTypeRule
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
                    // InternalMachineLearningLanguage.g:3962:3: this_VoidTypeRule_4= ruleVoidTypeRule
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
    // InternalMachineLearningLanguage.g:3977:1: entryRuleEnumReferenceRule returns [EObject current=null] : iv_ruleEnumReferenceRule= ruleEnumReferenceRule EOF ;
    public final EObject entryRuleEnumReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:3977:58: (iv_ruleEnumReferenceRule= ruleEnumReferenceRule EOF )
            // InternalMachineLearningLanguage.g:3978:2: iv_ruleEnumReferenceRule= ruleEnumReferenceRule EOF
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
    // InternalMachineLearningLanguage.g:3984:1: ruleEnumReferenceRule returns [EObject current=null] : (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleEnumReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:3990:2: ( (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) ) )
            // InternalMachineLearningLanguage.g:3991:2: (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) )
            {
            // InternalMachineLearningLanguage.g:3991:2: (otherlv_0= 'enum' ( ( ruleQualifiedName ) ) )
            // InternalMachineLearningLanguage.g:3992:3: otherlv_0= 'enum' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumReferenceRuleAccess().getEnumKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:3996:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:3997:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:3997:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:3998:5: ruleQualifiedName
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
    // InternalMachineLearningLanguage.g:4019:1: entryRuleTypeReferenceRule returns [EObject current=null] : iv_ruleTypeReferenceRule= ruleTypeReferenceRule EOF ;
    public final EObject entryRuleTypeReferenceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReferenceRule = null;


        try {
            // InternalMachineLearningLanguage.g:4019:58: (iv_ruleTypeReferenceRule= ruleTypeReferenceRule EOF )
            // InternalMachineLearningLanguage.g:4020:2: iv_ruleTypeReferenceRule= ruleTypeReferenceRule EOF
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
    // InternalMachineLearningLanguage.g:4026:1: ruleTypeReferenceRule returns [EObject current=null] : (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleTypeReferenceRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4032:2: ( (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) ) )
            // InternalMachineLearningLanguage.g:4033:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            {
            // InternalMachineLearningLanguage.g:4033:2: (otherlv_0= 'instance' ( ( ruleQualifiedName ) ) )
            // InternalMachineLearningLanguage.g:4034:3: otherlv_0= 'instance' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,66,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeReferenceRuleAccess().getInstanceKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:4038:3: ( ( ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:4039:4: ( ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:4039:4: ( ruleQualifiedName )
            // InternalMachineLearningLanguage.g:4040:5: ruleQualifiedName
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
    // InternalMachineLearningLanguage.g:4061:1: entryRuleLiteralTypeRule returns [EObject current=null] : iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF ;
    public final EObject entryRuleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:4061:56: (iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF )
            // InternalMachineLearningLanguage.g:4062:2: iv_ruleLiteralTypeRule= ruleLiteralTypeRule EOF
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
    // InternalMachineLearningLanguage.g:4068:1: ruleLiteralTypeRule returns [EObject current=null] : ( () otherlv_1= 'literal' ) ;
    public final EObject ruleLiteralTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4074:2: ( ( () otherlv_1= 'literal' ) )
            // InternalMachineLearningLanguage.g:4075:2: ( () otherlv_1= 'literal' )
            {
            // InternalMachineLearningLanguage.g:4075:2: ( () otherlv_1= 'literal' )
            // InternalMachineLearningLanguage.g:4076:3: () otherlv_1= 'literal'
            {
            // InternalMachineLearningLanguage.g:4076:3: ()
            // InternalMachineLearningLanguage.g:4077:4: 
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

            otherlv_1=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:4094:1: entryRuleDataTypeRule returns [EObject current=null] : iv_ruleDataTypeRule= ruleDataTypeRule EOF ;
    public final EObject entryRuleDataTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:4094:53: (iv_ruleDataTypeRule= ruleDataTypeRule EOF )
            // InternalMachineLearningLanguage.g:4095:2: iv_ruleDataTypeRule= ruleDataTypeRule EOF
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
    // InternalMachineLearningLanguage.g:4101:1: ruleDataTypeRule returns [EObject current=null] : ( () otherlv_1= 'data' ) ;
    public final EObject ruleDataTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4107:2: ( ( () otherlv_1= 'data' ) )
            // InternalMachineLearningLanguage.g:4108:2: ( () otherlv_1= 'data' )
            {
            // InternalMachineLearningLanguage.g:4108:2: ( () otherlv_1= 'data' )
            // InternalMachineLearningLanguage.g:4109:3: () otherlv_1= 'data'
            {
            // InternalMachineLearningLanguage.g:4109:3: ()
            // InternalMachineLearningLanguage.g:4110:4: 
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

            otherlv_1=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:4127:1: entryRuleStringTypeRule returns [EObject current=null] : iv_ruleStringTypeRule= ruleStringTypeRule EOF ;
    public final EObject entryRuleStringTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:4127:55: (iv_ruleStringTypeRule= ruleStringTypeRule EOF )
            // InternalMachineLearningLanguage.g:4128:2: iv_ruleStringTypeRule= ruleStringTypeRule EOF
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
    // InternalMachineLearningLanguage.g:4134:1: ruleStringTypeRule returns [EObject current=null] : ( () otherlv_1= 'string' ) ;
    public final EObject ruleStringTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4140:2: ( ( () otherlv_1= 'string' ) )
            // InternalMachineLearningLanguage.g:4141:2: ( () otherlv_1= 'string' )
            {
            // InternalMachineLearningLanguage.g:4141:2: ( () otherlv_1= 'string' )
            // InternalMachineLearningLanguage.g:4142:3: () otherlv_1= 'string'
            {
            // InternalMachineLearningLanguage.g:4142:3: ()
            // InternalMachineLearningLanguage.g:4143:4: 
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

            otherlv_1=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:4160:1: entryRuleExpressionTypeRule returns [EObject current=null] : iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF ;
    public final EObject entryRuleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:4160:59: (iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF )
            // InternalMachineLearningLanguage.g:4161:2: iv_ruleExpressionTypeRule= ruleExpressionTypeRule EOF
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
    // InternalMachineLearningLanguage.g:4167:1: ruleExpressionTypeRule returns [EObject current=null] : ( () otherlv_1= 'expression' ) ;
    public final EObject ruleExpressionTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4173:2: ( ( () otherlv_1= 'expression' ) )
            // InternalMachineLearningLanguage.g:4174:2: ( () otherlv_1= 'expression' )
            {
            // InternalMachineLearningLanguage.g:4174:2: ( () otherlv_1= 'expression' )
            // InternalMachineLearningLanguage.g:4175:3: () otherlv_1= 'expression'
            {
            // InternalMachineLearningLanguage.g:4175:3: ()
            // InternalMachineLearningLanguage.g:4176:4: 
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

            otherlv_1=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:4193:1: entryRuleIntTypeRule returns [EObject current=null] : iv_ruleIntTypeRule= ruleIntTypeRule EOF ;
    public final EObject entryRuleIntTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:4193:52: (iv_ruleIntTypeRule= ruleIntTypeRule EOF )
            // InternalMachineLearningLanguage.g:4194:2: iv_ruleIntTypeRule= ruleIntTypeRule EOF
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
    // InternalMachineLearningLanguage.g:4200:1: ruleIntTypeRule returns [EObject current=null] : ( () otherlv_1= 'int' ) ;
    public final EObject ruleIntTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4206:2: ( ( () otherlv_1= 'int' ) )
            // InternalMachineLearningLanguage.g:4207:2: ( () otherlv_1= 'int' )
            {
            // InternalMachineLearningLanguage.g:4207:2: ( () otherlv_1= 'int' )
            // InternalMachineLearningLanguage.g:4208:3: () otherlv_1= 'int'
            {
            // InternalMachineLearningLanguage.g:4208:3: ()
            // InternalMachineLearningLanguage.g:4209:4: 
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

            otherlv_1=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:4226:1: entryRuleRealTypeRule returns [EObject current=null] : iv_ruleRealTypeRule= ruleRealTypeRule EOF ;
    public final EObject entryRuleRealTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:4226:53: (iv_ruleRealTypeRule= ruleRealTypeRule EOF )
            // InternalMachineLearningLanguage.g:4227:2: iv_ruleRealTypeRule= ruleRealTypeRule EOF
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
    // InternalMachineLearningLanguage.g:4233:1: ruleRealTypeRule returns [EObject current=null] : ( () otherlv_1= 'real' ) ;
    public final EObject ruleRealTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4239:2: ( ( () otherlv_1= 'real' ) )
            // InternalMachineLearningLanguage.g:4240:2: ( () otherlv_1= 'real' )
            {
            // InternalMachineLearningLanguage.g:4240:2: ( () otherlv_1= 'real' )
            // InternalMachineLearningLanguage.g:4241:3: () otherlv_1= 'real'
            {
            // InternalMachineLearningLanguage.g:4241:3: ()
            // InternalMachineLearningLanguage.g:4242:4: 
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

            otherlv_1=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:4259:1: entryRuleBooleanTypeRule returns [EObject current=null] : iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF ;
    public final EObject entryRuleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:4259:56: (iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF )
            // InternalMachineLearningLanguage.g:4260:2: iv_ruleBooleanTypeRule= ruleBooleanTypeRule EOF
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
    // InternalMachineLearningLanguage.g:4266:1: ruleBooleanTypeRule returns [EObject current=null] : ( () otherlv_1= 'boolean' ) ;
    public final EObject ruleBooleanTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4272:2: ( ( () otherlv_1= 'boolean' ) )
            // InternalMachineLearningLanguage.g:4273:2: ( () otherlv_1= 'boolean' )
            {
            // InternalMachineLearningLanguage.g:4273:2: ( () otherlv_1= 'boolean' )
            // InternalMachineLearningLanguage.g:4274:3: () otherlv_1= 'boolean'
            {
            // InternalMachineLearningLanguage.g:4274:3: ()
            // InternalMachineLearningLanguage.g:4275:4: 
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

            otherlv_1=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:4292:1: entryRuleVoidTypeRule returns [EObject current=null] : iv_ruleVoidTypeRule= ruleVoidTypeRule EOF ;
    public final EObject entryRuleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoidTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:4292:53: (iv_ruleVoidTypeRule= ruleVoidTypeRule EOF )
            // InternalMachineLearningLanguage.g:4293:2: iv_ruleVoidTypeRule= ruleVoidTypeRule EOF
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
    // InternalMachineLearningLanguage.g:4299:1: ruleVoidTypeRule returns [EObject current=null] : ( () otherlv_1= 'void' ) ;
    public final EObject ruleVoidTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4305:2: ( ( () otherlv_1= 'void' ) )
            // InternalMachineLearningLanguage.g:4306:2: ( () otherlv_1= 'void' )
            {
            // InternalMachineLearningLanguage.g:4306:2: ( () otherlv_1= 'void' )
            // InternalMachineLearningLanguage.g:4307:3: () otherlv_1= 'void'
            {
            // InternalMachineLearningLanguage.g:4307:3: ()
            // InternalMachineLearningLanguage.g:4308:4: 
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

            otherlv_1=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:4325:1: entryRuleArrayTypeRule returns [EObject current=null] : iv_ruleArrayTypeRule= ruleArrayTypeRule EOF ;
    public final EObject entryRuleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayTypeRule = null;


        try {
            // InternalMachineLearningLanguage.g:4325:54: (iv_ruleArrayTypeRule= ruleArrayTypeRule EOF )
            // InternalMachineLearningLanguage.g:4326:2: iv_ruleArrayTypeRule= ruleArrayTypeRule EOF
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
    // InternalMachineLearningLanguage.g:4332:1: ruleArrayTypeRule returns [EObject current=null] : (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) ;
    public final EObject ruleArrayTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4338:2: ( (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) ) )
            // InternalMachineLearningLanguage.g:4339:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            {
            // InternalMachineLearningLanguage.g:4339:2: (otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) ) )
            // InternalMachineLearningLanguage.g:4340:3: otherlv_0= 'array' ( (lv_elements_1_0= ruleTypeRule ) )
            {
            otherlv_0=(Token)match(input,81,FOLLOW_72); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getArrayTypeRuleAccess().getArrayKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:4344:3: ( (lv_elements_1_0= ruleTypeRule ) )
            // InternalMachineLearningLanguage.g:4345:4: (lv_elements_1_0= ruleTypeRule )
            {
            // InternalMachineLearningLanguage.g:4345:4: (lv_elements_1_0= ruleTypeRule )
            // InternalMachineLearningLanguage.g:4346:5: lv_elements_1_0= ruleTypeRule
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
    // InternalMachineLearningLanguage.g:4367:1: entryRuleParameterRule returns [EObject current=null] : iv_ruleParameterRule= ruleParameterRule EOF ;
    public final EObject entryRuleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRule = null;


        try {
            // InternalMachineLearningLanguage.g:4367:54: (iv_ruleParameterRule= ruleParameterRule EOF )
            // InternalMachineLearningLanguage.g:4368:2: iv_ruleParameterRule= ruleParameterRule EOF
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
    // InternalMachineLearningLanguage.g:4374:1: ruleParameterRule returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) ;
    public final EObject ruleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4380:2: ( ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) ) )
            // InternalMachineLearningLanguage.g:4381:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            {
            // InternalMachineLearningLanguage.g:4381:2: ( ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) ) )
            // InternalMachineLearningLanguage.g:4382:3: ( (lv_type_0_0= ruleTypeRule ) ) ( (lv_name_1_0= ruleStringOrId ) )
            {
            // InternalMachineLearningLanguage.g:4382:3: ( (lv_type_0_0= ruleTypeRule ) )
            // InternalMachineLearningLanguage.g:4383:4: (lv_type_0_0= ruleTypeRule )
            {
            // InternalMachineLearningLanguage.g:4383:4: (lv_type_0_0= ruleTypeRule )
            // InternalMachineLearningLanguage.g:4384:5: lv_type_0_0= ruleTypeRule
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

            // InternalMachineLearningLanguage.g:4401:3: ( (lv_name_1_0= ruleStringOrId ) )
            // InternalMachineLearningLanguage.g:4402:4: (lv_name_1_0= ruleStringOrId )
            {
            // InternalMachineLearningLanguage.g:4402:4: (lv_name_1_0= ruleStringOrId )
            // InternalMachineLearningLanguage.g:4403:5: lv_name_1_0= ruleStringOrId
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
    // InternalMachineLearningLanguage.g:4424:1: entryRuleImportRule returns [EObject current=null] : iv_ruleImportRule= ruleImportRule EOF ;
    public final EObject entryRuleImportRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportRule = null;


        try {
            // InternalMachineLearningLanguage.g:4424:51: (iv_ruleImportRule= ruleImportRule EOF )
            // InternalMachineLearningLanguage.g:4425:2: iv_ruleImportRule= ruleImportRule EOF
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
    // InternalMachineLearningLanguage.g:4431:1: ruleImportRule returns [EObject current=null] : (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' ) ;
    public final EObject ruleImportRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_language_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_importedNamespace_3_0 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4437:2: ( (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' ) )
            // InternalMachineLearningLanguage.g:4438:2: (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' )
            {
            // InternalMachineLearningLanguage.g:4438:2: (otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';' )
            // InternalMachineLearningLanguage.g:4439:3: otherlv_0= 'import' ( (lv_language_1_0= RULE_STRING ) ) otherlv_2= 'from' ( (lv_importedNamespace_3_0= ruleQualifiedName ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportRuleAccess().getImportKeyword_0());
              		
            }
            // InternalMachineLearningLanguage.g:4443:3: ( (lv_language_1_0= RULE_STRING ) )
            // InternalMachineLearningLanguage.g:4444:4: (lv_language_1_0= RULE_STRING )
            {
            // InternalMachineLearningLanguage.g:4444:4: (lv_language_1_0= RULE_STRING )
            // InternalMachineLearningLanguage.g:4445:5: lv_language_1_0= RULE_STRING
            {
            lv_language_1_0=(Token)match(input,RULE_STRING,FOLLOW_22); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,31,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getImportRuleAccess().getFromKeyword_2());
              		
            }
            // InternalMachineLearningLanguage.g:4465:3: ( (lv_importedNamespace_3_0= ruleQualifiedName ) )
            // InternalMachineLearningLanguage.g:4466:4: (lv_importedNamespace_3_0= ruleQualifiedName )
            {
            // InternalMachineLearningLanguage.g:4466:4: (lv_importedNamespace_3_0= ruleQualifiedName )
            // InternalMachineLearningLanguage.g:4467:5: lv_importedNamespace_3_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getImportRuleAccess().getImportedNamespaceQualifiedNameParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_14);
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

            otherlv_4=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:4492:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalMachineLearningLanguage.g:4492:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalMachineLearningLanguage.g:4493:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalMachineLearningLanguage.g:4499:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_StringOrId_0 = null;

        AntlrDatatypeRuleToken this_StringOrId_2 = null;



        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4505:2: ( (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* ) )
            // InternalMachineLearningLanguage.g:4506:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            {
            // InternalMachineLearningLanguage.g:4506:2: (this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )* )
            // InternalMachineLearningLanguage.g:4507:3: this_StringOrId_0= ruleStringOrId (kw= '.' this_StringOrId_2= ruleStringOrId )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_74);
            this_StringOrId_0=ruleStringOrId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_StringOrId_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMachineLearningLanguage.g:4517:3: (kw= '.' this_StringOrId_2= ruleStringOrId )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==83) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalMachineLearningLanguage.g:4518:4: kw= '.' this_StringOrId_2= ruleStringOrId
            	    {
            	    kw=(Token)match(input,83,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getQualifiedNameAccess().getStringOrIdParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_74);
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
            	    break loop59;
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
    // InternalMachineLearningLanguage.g:4538:1: entryRuleStringOrId returns [String current=null] : iv_ruleStringOrId= ruleStringOrId EOF ;
    public final String entryRuleStringOrId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringOrId = null;


        try {
            // InternalMachineLearningLanguage.g:4538:50: (iv_ruleStringOrId= ruleStringOrId EOF )
            // InternalMachineLearningLanguage.g:4539:2: iv_ruleStringOrId= ruleStringOrId EOF
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
    // InternalMachineLearningLanguage.g:4545:1: ruleStringOrId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleStringOrId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_QUOTED_ID_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4551:2: ( (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID ) )
            // InternalMachineLearningLanguage.g:4552:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            {
            // InternalMachineLearningLanguage.g:4552:2: (this_QUOTED_ID_0= RULE_QUOTED_ID | this_ID_1= RULE_ID )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_QUOTED_ID) ) {
                alt60=1;
            }
            else if ( (LA60_0==RULE_ID) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalMachineLearningLanguage.g:4553:3: this_QUOTED_ID_0= RULE_QUOTED_ID
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
                    // InternalMachineLearningLanguage.g:4561:3: this_ID_1= RULE_ID
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
    // InternalMachineLearningLanguage.g:4572:1: ruleComparisonOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalMachineLearningLanguage.g:4578:2: ( ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) ) )
            // InternalMachineLearningLanguage.g:4579:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalMachineLearningLanguage.g:4579:2: ( (enumLiteral_0= '>=' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '<=' ) )
            int alt61=6;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt61=1;
                }
                break;
            case 85:
                {
                alt61=2;
                }
                break;
            case 86:
                {
                alt61=3;
                }
                break;
            case 87:
                {
                alt61=4;
                }
                break;
            case 88:
                {
                alt61=5;
                }
                break;
            case 89:
                {
                alt61=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // InternalMachineLearningLanguage.g:4580:3: (enumLiteral_0= '>=' )
                    {
                    // InternalMachineLearningLanguage.g:4580:3: (enumLiteral_0= '>=' )
                    // InternalMachineLearningLanguage.g:4581:4: enumLiteral_0= '>='
                    {
                    enumLiteral_0=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorRuleAccess().getGreaterThanEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:4588:3: (enumLiteral_1= '>' )
                    {
                    // InternalMachineLearningLanguage.g:4588:3: (enumLiteral_1= '>' )
                    // InternalMachineLearningLanguage.g:4589:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorRuleAccess().getGreaterEqualEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMachineLearningLanguage.g:4596:3: (enumLiteral_2= '=' )
                    {
                    // InternalMachineLearningLanguage.g:4596:3: (enumLiteral_2= '=' )
                    // InternalMachineLearningLanguage.g:4597:4: enumLiteral_2= '='
                    {
                    enumLiteral_2=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorRuleAccess().getEqualEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalMachineLearningLanguage.g:4604:3: (enumLiteral_3= '!=' )
                    {
                    // InternalMachineLearningLanguage.g:4604:3: (enumLiteral_3= '!=' )
                    // InternalMachineLearningLanguage.g:4605:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorRuleAccess().getUnequalEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalMachineLearningLanguage.g:4612:3: (enumLiteral_4= '<' )
                    {
                    // InternalMachineLearningLanguage.g:4612:3: (enumLiteral_4= '<' )
                    // InternalMachineLearningLanguage.g:4613:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorRuleAccess().getLessEqualEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalMachineLearningLanguage.g:4620:3: (enumLiteral_5= '<=' )
                    {
                    // InternalMachineLearningLanguage.g:4620:3: (enumLiteral_5= '<=' )
                    // InternalMachineLearningLanguage.g:4621:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:4631:1: ruleAddOrSubtractOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOrSubtractOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4637:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalMachineLearningLanguage.g:4638:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalMachineLearningLanguage.g:4638:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==90) ) {
                alt62=1;
            }
            else if ( (LA62_0==91) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalMachineLearningLanguage.g:4639:3: (enumLiteral_0= '+' )
                    {
                    // InternalMachineLearningLanguage.g:4639:3: (enumLiteral_0= '+' )
                    // InternalMachineLearningLanguage.g:4640:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAddOrSubtractOperatorRuleAccess().getAddEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:4647:3: (enumLiteral_1= '-' )
                    {
                    // InternalMachineLearningLanguage.g:4647:3: (enumLiteral_1= '-' )
                    // InternalMachineLearningLanguage.g:4648:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:4658:1: ruleMultiplyDivideModuloOperatorRule returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplyDivideModuloOperatorRule() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMachineLearningLanguage.g:4664:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalMachineLearningLanguage.g:4665:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalMachineLearningLanguage.g:4665:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt63=3;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt63=1;
                }
                break;
            case 93:
                {
                alt63=2;
                }
                break;
            case 94:
                {
                alt63=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // InternalMachineLearningLanguage.g:4666:3: (enumLiteral_0= '*' )
                    {
                    // InternalMachineLearningLanguage.g:4666:3: (enumLiteral_0= '*' )
                    // InternalMachineLearningLanguage.g:4667:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getMultiplyEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:4674:3: (enumLiteral_1= '/' )
                    {
                    // InternalMachineLearningLanguage.g:4674:3: (enumLiteral_1= '/' )
                    // InternalMachineLearningLanguage.g:4675:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplyDivideModuloOperatorRuleAccess().getDivideEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMachineLearningLanguage.g:4682:3: (enumLiteral_2= '%' )
                    {
                    // InternalMachineLearningLanguage.g:4682:3: (enumLiteral_2= '%' )
                    // InternalMachineLearningLanguage.g:4683:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
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
    // InternalMachineLearningLanguage.g:4693:1: ruleFactorRule returns [Enumerator current=null] : ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) ;
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
            // InternalMachineLearningLanguage.g:4699:2: ( ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) ) )
            // InternalMachineLearningLanguage.g:4700:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            {
            // InternalMachineLearningLanguage.g:4700:2: ( (enumLiteral_0= 'Y' ) | (enumLiteral_1= 'Z' ) | (enumLiteral_2= 'E' ) | (enumLiteral_3= 'P' ) | (enumLiteral_4= 'T' ) | (enumLiteral_5= 'G' ) | (enumLiteral_6= 'M' ) | (enumLiteral_7= 'k' ) | (enumLiteral_8= 'h' ) | (enumLiteral_9= 'da' ) | (enumLiteral_10= 'd' ) | (enumLiteral_11= 'c' ) | (enumLiteral_12= 'm' ) | (enumLiteral_13= '\\u00B5' ) | (enumLiteral_14= 'n' ) | (enumLiteral_15= 'p' ) | (enumLiteral_16= 'f' ) | (enumLiteral_17= 'a' ) | (enumLiteral_18= 'z' ) | (enumLiteral_19= 'y' ) )
            int alt64=20;
            switch ( input.LA(1) ) {
            case 95:
                {
                alt64=1;
                }
                break;
            case 96:
                {
                alt64=2;
                }
                break;
            case 97:
                {
                alt64=3;
                }
                break;
            case 98:
                {
                alt64=4;
                }
                break;
            case 99:
                {
                alt64=5;
                }
                break;
            case 100:
                {
                alt64=6;
                }
                break;
            case 101:
                {
                alt64=7;
                }
                break;
            case 102:
                {
                alt64=8;
                }
                break;
            case 103:
                {
                alt64=9;
                }
                break;
            case 104:
                {
                alt64=10;
                }
                break;
            case 105:
                {
                alt64=11;
                }
                break;
            case 106:
                {
                alt64=12;
                }
                break;
            case 107:
                {
                alt64=13;
                }
                break;
            case 108:
                {
                alt64=14;
                }
                break;
            case 109:
                {
                alt64=15;
                }
                break;
            case 110:
                {
                alt64=16;
                }
                break;
            case 111:
                {
                alt64=17;
                }
                break;
            case 112:
                {
                alt64=18;
                }
                break;
            case 113:
                {
                alt64=19;
                }
                break;
            case 114:
                {
                alt64=20;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // InternalMachineLearningLanguage.g:4701:3: (enumLiteral_0= 'Y' )
                    {
                    // InternalMachineLearningLanguage.g:4701:3: (enumLiteral_0= 'Y' )
                    // InternalMachineLearningLanguage.g:4702:4: enumLiteral_0= 'Y'
                    {
                    enumLiteral_0=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getFactorRuleAccess().getYottaEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMachineLearningLanguage.g:4709:3: (enumLiteral_1= 'Z' )
                    {
                    // InternalMachineLearningLanguage.g:4709:3: (enumLiteral_1= 'Z' )
                    // InternalMachineLearningLanguage.g:4710:4: enumLiteral_1= 'Z'
                    {
                    enumLiteral_1=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getFactorRuleAccess().getZettaEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMachineLearningLanguage.g:4717:3: (enumLiteral_2= 'E' )
                    {
                    // InternalMachineLearningLanguage.g:4717:3: (enumLiteral_2= 'E' )
                    // InternalMachineLearningLanguage.g:4718:4: enumLiteral_2= 'E'
                    {
                    enumLiteral_2=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getFactorRuleAccess().getExaEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalMachineLearningLanguage.g:4725:3: (enumLiteral_3= 'P' )
                    {
                    // InternalMachineLearningLanguage.g:4725:3: (enumLiteral_3= 'P' )
                    // InternalMachineLearningLanguage.g:4726:4: enumLiteral_3= 'P'
                    {
                    enumLiteral_3=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getFactorRuleAccess().getPetaEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalMachineLearningLanguage.g:4733:3: (enumLiteral_4= 'T' )
                    {
                    // InternalMachineLearningLanguage.g:4733:3: (enumLiteral_4= 'T' )
                    // InternalMachineLearningLanguage.g:4734:4: enumLiteral_4= 'T'
                    {
                    enumLiteral_4=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getFactorRuleAccess().getTeraEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalMachineLearningLanguage.g:4741:3: (enumLiteral_5= 'G' )
                    {
                    // InternalMachineLearningLanguage.g:4741:3: (enumLiteral_5= 'G' )
                    // InternalMachineLearningLanguage.g:4742:4: enumLiteral_5= 'G'
                    {
                    enumLiteral_5=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getFactorRuleAccess().getGigaEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalMachineLearningLanguage.g:4749:3: (enumLiteral_6= 'M' )
                    {
                    // InternalMachineLearningLanguage.g:4749:3: (enumLiteral_6= 'M' )
                    // InternalMachineLearningLanguage.g:4750:4: enumLiteral_6= 'M'
                    {
                    enumLiteral_6=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getFactorRuleAccess().getMegaEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalMachineLearningLanguage.g:4757:3: (enumLiteral_7= 'k' )
                    {
                    // InternalMachineLearningLanguage.g:4757:3: (enumLiteral_7= 'k' )
                    // InternalMachineLearningLanguage.g:4758:4: enumLiteral_7= 'k'
                    {
                    enumLiteral_7=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getFactorRuleAccess().getKiloEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalMachineLearningLanguage.g:4765:3: (enumLiteral_8= 'h' )
                    {
                    // InternalMachineLearningLanguage.g:4765:3: (enumLiteral_8= 'h' )
                    // InternalMachineLearningLanguage.g:4766:4: enumLiteral_8= 'h'
                    {
                    enumLiteral_8=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getFactorRuleAccess().getHectoEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalMachineLearningLanguage.g:4773:3: (enumLiteral_9= 'da' )
                    {
                    // InternalMachineLearningLanguage.g:4773:3: (enumLiteral_9= 'da' )
                    // InternalMachineLearningLanguage.g:4774:4: enumLiteral_9= 'da'
                    {
                    enumLiteral_9=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getFactorRuleAccess().getDekaEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalMachineLearningLanguage.g:4781:3: (enumLiteral_10= 'd' )
                    {
                    // InternalMachineLearningLanguage.g:4781:3: (enumLiteral_10= 'd' )
                    // InternalMachineLearningLanguage.g:4782:4: enumLiteral_10= 'd'
                    {
                    enumLiteral_10=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getFactorRuleAccess().getDeciEnumLiteralDeclaration_10());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalMachineLearningLanguage.g:4789:3: (enumLiteral_11= 'c' )
                    {
                    // InternalMachineLearningLanguage.g:4789:3: (enumLiteral_11= 'c' )
                    // InternalMachineLearningLanguage.g:4790:4: enumLiteral_11= 'c'
                    {
                    enumLiteral_11=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_11, grammarAccess.getFactorRuleAccess().getCentiEnumLiteralDeclaration_11());
                      			
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalMachineLearningLanguage.g:4797:3: (enumLiteral_12= 'm' )
                    {
                    // InternalMachineLearningLanguage.g:4797:3: (enumLiteral_12= 'm' )
                    // InternalMachineLearningLanguage.g:4798:4: enumLiteral_12= 'm'
                    {
                    enumLiteral_12=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_12, grammarAccess.getFactorRuleAccess().getMilliEnumLiteralDeclaration_12());
                      			
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalMachineLearningLanguage.g:4805:3: (enumLiteral_13= '\\u00B5' )
                    {
                    // InternalMachineLearningLanguage.g:4805:3: (enumLiteral_13= '\\u00B5' )
                    // InternalMachineLearningLanguage.g:4806:4: enumLiteral_13= '\\u00B5'
                    {
                    enumLiteral_13=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_13, grammarAccess.getFactorRuleAccess().getMicroEnumLiteralDeclaration_13());
                      			
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalMachineLearningLanguage.g:4813:3: (enumLiteral_14= 'n' )
                    {
                    // InternalMachineLearningLanguage.g:4813:3: (enumLiteral_14= 'n' )
                    // InternalMachineLearningLanguage.g:4814:4: enumLiteral_14= 'n'
                    {
                    enumLiteral_14=(Token)match(input,109,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_14, grammarAccess.getFactorRuleAccess().getNanoEnumLiteralDeclaration_14());
                      			
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalMachineLearningLanguage.g:4821:3: (enumLiteral_15= 'p' )
                    {
                    // InternalMachineLearningLanguage.g:4821:3: (enumLiteral_15= 'p' )
                    // InternalMachineLearningLanguage.g:4822:4: enumLiteral_15= 'p'
                    {
                    enumLiteral_15=(Token)match(input,110,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_15, grammarAccess.getFactorRuleAccess().getPikoEnumLiteralDeclaration_15());
                      			
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalMachineLearningLanguage.g:4829:3: (enumLiteral_16= 'f' )
                    {
                    // InternalMachineLearningLanguage.g:4829:3: (enumLiteral_16= 'f' )
                    // InternalMachineLearningLanguage.g:4830:4: enumLiteral_16= 'f'
                    {
                    enumLiteral_16=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_16, grammarAccess.getFactorRuleAccess().getFemtoEnumLiteralDeclaration_16());
                      			
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalMachineLearningLanguage.g:4837:3: (enumLiteral_17= 'a' )
                    {
                    // InternalMachineLearningLanguage.g:4837:3: (enumLiteral_17= 'a' )
                    // InternalMachineLearningLanguage.g:4838:4: enumLiteral_17= 'a'
                    {
                    enumLiteral_17=(Token)match(input,112,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_17, grammarAccess.getFactorRuleAccess().getAttoEnumLiteralDeclaration_17());
                      			
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalMachineLearningLanguage.g:4845:3: (enumLiteral_18= 'z' )
                    {
                    // InternalMachineLearningLanguage.g:4845:3: (enumLiteral_18= 'z' )
                    // InternalMachineLearningLanguage.g:4846:4: enumLiteral_18= 'z'
                    {
                    enumLiteral_18=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_18, grammarAccess.getFactorRuleAccess().getZeptoEnumLiteralDeclaration_18());
                      			
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalMachineLearningLanguage.g:4853:3: (enumLiteral_19= 'y' )
                    {
                    // InternalMachineLearningLanguage.g:4853:3: (enumLiteral_19= 'y' )
                    // InternalMachineLearningLanguage.g:4854:4: enumLiteral_19= 'y'
                    {
                    enumLiteral_19=(Token)match(input,114,FOLLOW_2); if (state.failed) return current;
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

    // $ANTLR start synpred34_InternalMachineLearningLanguage
    public final void synpred34_InternalMachineLearningLanguage_fragment() throws RecognitionException {   
        EObject this_ValuelDefinitionReferenceRule_0 = null;


        // InternalMachineLearningLanguage.g:1928:3: (this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule )
        // InternalMachineLearningLanguage.g:1928:3: this_ValuelDefinitionReferenceRule_0= ruleValuelDefinitionReferenceRule
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
    // $ANTLR end synpred34_InternalMachineLearningLanguage

    // Delegated rules

    public final boolean synpred34_InternalMachineLearningLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalMachineLearningLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA27 dfa27 = new DFA27(this);
    protected DFA42 dfa42 = new DFA42(this);
    static final String dfa_1s = "\31\uffff";
    static final String dfa_2s = "\1\40\1\4\1\uffff\25\34\1\uffff";
    static final String dfa_3s = "\1\40\1\105\1\uffff\1\162\24\45\1\uffff";
    static final String dfa_4s = "\2\uffff\1\2\25\uffff\1\1";
    static final String dfa_5s = "\31\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\2\2\1\3\2\2\27\uffff\1\2\13\uffff\2\2\12\uffff\1\2\10\uffff\2\2\1\uffff\2\2",
            "",
            "\1\2\4\uffff\1\2\3\uffff\1\30\71\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            "\1\2\4\uffff\1\2\3\uffff\1\30",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1586:2: (this_CounterRangeRule_0= ruleCounterRangeRule | this_LiteralRangeRule_1= ruleLiteralRangeRule )";
        }
    }
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\2\uffff\2\6\5\uffff\2\6";
    static final String dfa_9s = "\1\4\1\uffff\2\20\3\uffff\1\7\1\uffff\2\20";
    static final String dfa_10s = "\1\105\1\uffff\2\136\3\uffff\1\10\1\uffff\2\136";
    static final String dfa_11s = "\1\uffff\1\1\2\uffff\1\3\1\4\1\5\1\uffff\1\2\2\uffff";
    static final String dfa_12s = "\13\uffff}>";
    static final String[] dfa_13s = {
            "\3\4\1\2\1\3\27\uffff\1\1\13\uffff\2\4\12\uffff\1\5\10\uffff\2\6\1\uffff\2\4",
            "",
            "\1\4\5\uffff\1\6\5\uffff\1\6\4\uffff\1\6\26\uffff\1\10\4\6\1\uffff\1\6\24\uffff\1\7\13\6",
            "\1\4\5\uffff\1\6\5\uffff\1\6\4\uffff\1\6\26\uffff\1\10\4\6\1\uffff\1\6\24\uffff\1\7\13\6",
            "",
            "",
            "",
            "\1\11\1\12",
            "",
            "\1\4\5\uffff\1\6\5\uffff\1\6\4\uffff\1\6\26\uffff\1\10\4\6\1\uffff\1\6\24\uffff\1\7\13\6",
            "\1\4\5\uffff\1\6\5\uffff\1\6\4\uffff\1\6\26\uffff\1\10\4\6\1\uffff\1\6\24\uffff\1\7\13\6"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "2772:2: (this_ArrayRule_0= ruleArrayRule | this_CallRule_1= ruleCallRule | this_LiteralRule_2= ruleLiteralRule | this_ParanthesesRule_3= ruleParanthesesRule | this_ReferenceRule_4= ruleReferenceRule )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008000L,0x0000000000040000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000001120000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001100000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000820000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000210000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000001400000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000004001000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000300200000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0022000000800180L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000300000800000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0001800001000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000200000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0001000001000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x01003001000001F0L,0x0000000000000036L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x00003000000001F0L,0x0000000000000030L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x23003001000001F0L,0x000000000C000036L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0200000010000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x21003001000001F0L,0x000000000C000036L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000002L,0x0000000003F00000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000002L,0x0000000070000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x01003001000001F0L,0x000000000C000036L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x01003003000001F0L,0x0000000000000036L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000001000180L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x0007FFFF80000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000180L,0x0000000000000040L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x000000000003FF06L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000400000L,0x0000000000000008L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});

}