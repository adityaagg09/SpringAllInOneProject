package Base.LandingPage.CustomAnnotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// These retention policies determine at which point an annotation is discarded
// RetentionPolicy.CLASS are recorded in the .class file but discarded during runtime, it is the default
// RetentionPolicy.SOURCE it is discarded during runtime
@Target({ElementType.METHOD}) //
@Retention(RetentionPolicy.RUNTIME) // Annotations used during runtime & can be accessed in program during runtime
public @interface TrackExecutionTime {
}
