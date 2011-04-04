package morph.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.stereotype.Component;

@Component
@Retention(RetentionPolicy.RUNTIME)
public @interface TagLib {
	String prefix();
}
