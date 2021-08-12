package studio.dates.javamodule.validator.classvalidator;

import studio.dates.javamodule.validator.enums.ValidationMethod;
import studio.dates.javamodule.validator.exception.ValidationException;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Class Validator provides Validation sequence for specified class.
 *
 * <blockquote>
 * Example:
 * <ol>
 *      <li>Building<br>
 *          &nbsp;&nbsp;public static final ClassValidator&lt;Person&gt; validator =<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;new ClassValidator()<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;.method(ValidationMethod.SYNCHRONOUS)<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;.constraint(entity -> Validator.NotNull(entity.getId(), "id"))<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;.constraint(entity -> Validator.isEmail(entity.getEmail(), Nullable.NOT_NULL, "email"));<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;.constraint(entity -> {<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if(entity.getGender == "male") {Validator.isNull(entity.getPregnant(), "pregnant")}<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;});
 *      </li>
 *      <li>Validating<br>
 *          &nbsp;&nbsp;validator.validate(entity);
 *      </li>
 * </ol>
 * </blockquote>
 *
 * @author Laurence B. Yamamoto (DatesStudio int Toyohashi, JAPAN)
 *
 * @version 1.0.0 (Aug. 12, 2021)
 *
 * @param <T> Class of validation Target
 */
public class ClassValidator<T> {
    /**
     * The private field to store validation method setting.
     */
    private ValidationMethod method;

    /**
     * The private field to store all the constraint set as a list.
     */
    private List<Consumer<T>> constraints;

    /**
     * Constructor without any argument.
     */
    public ClassValidator() {
    }

    /**
     * Set validation method of the validation chain.
     *
     * @param method Two options:<br>
     *               1. SYNCHRONOUS: all the validation constraints are processed not depending on the results of other constraints.<br>
     *               On exception, Validation Exception with the result messages from all the failed constraints is thrown.
     * @return ChainValidator with new ValidationMethod value. This method is intended to be used as a part of the method chain.
     */
    public ClassValidator<T> method(ValidationMethod method) {
        this.method = method;
        return this;
    }

    /**
     * Add a constraint to the validation chain.
     *
     * @param constraint Constraint to be added to the validation chain.<br>
     *                   Constraint must be a Consumer of validation target.
     * @return ChainValidator with the new constraint. This method is intended to be used as a part of the method chain.
     */
    public ClassValidator<T> constraint(Consumer<T> constraint) {
        if(constraints == null) {constraints = new LinkedList<>();}
        this.constraints.add(constraint);
        return this;
    }

    /**
     * Run validation process for the target.
     *
     * @param target validation target.
     * @throws ValidationException Validation Exception thrown when the validation fails.<br>
     *                             A Subclass of ValidationException will be thrown when the validation method is set SEQUENCIAL.
     */
    public void validate(T target) throws ValidationException {
        switch (method) {
            case SEQUENTIAL:
                for (Consumer<T> constraint : this.constraints) {
                    constraint.accept(target);
                }
            case SYNCHRONOUS:
                String message = null;
                for (Consumer<T> constraint : this.constraints) {
                    try {
                        constraint.accept(target);
                    } catch (ValidationException e) {
                        if (message == null) {
                            message = e.getMessage();
                        } else {
                            message = String.join(message, "\n", e.getMessage());
                        }
                    }
                }
                if (message != null) {
                    throw new ValidationException(message);
                }
        }
    }
}
