package act.data.annotation;

import act.data.ContentLinesBinder;
import act.data.ContentLinesResolver;
import act.data.ContentStringBinder;
import act.data.ContentStringResolver;
import org.osgl.mvc.annotation.Bind;
import org.osgl.mvc.annotation.Resolve;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicate if the parameter is a file path or resource URL, then read the content of the file into the parameter,
 * otherwise leave the parameter as it is unless {@link #reportError()} is set to `true`
 *
 * Note this assumes the file or URL resource is a text file
 */
@Resolve({ContentStringResolver.class, ContentLinesResolver.class})
@Bind({ContentStringBinder.class, ContentLinesBinder.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
public @interface ReadContent {
    /**
     * When set to `true` the framework will throw out exception if it failed to read the content
     *
     * default value: `false`
     */
    boolean reportError() default false;
}
