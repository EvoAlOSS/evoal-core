package de.evoal.core.api.cdi;

import jakarta.enterprise.context.NormalScope;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@NormalScope(passivating = false)
public @interface RunScoped {
}