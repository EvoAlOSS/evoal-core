grammar InstanceLanguage
import 'BaseLanguage'
import 'model-types'
import 'model-types'
import 'expressions-types'
import 'definitions-types'
import 'types-types'

entry InstanceModuleRule returns InstanceModule:
    {InstanceModule} (imports+=ImportRule )* 'instances' '=' '[' ('instance' instances+=InstanceLiteralRule  (',' 'instance' instances+=InstanceLiteralRule  )* )? ']' ';'  
;

