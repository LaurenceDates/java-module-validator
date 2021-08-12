package studio.dates.javamodule.validator.classbooleanvalidator;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * Class Boolean Validator provides Validation sequence for specified class.
 *
 * <blockquote>
 * Example:
 * <ol>
 *     <li>Building<br>
 *          &nbsp;&nbsp;public static final ClassBooleanValidator&lt;Person&gt;  validator =<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;new ClassBooleanValidator()<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;.constraint(entity -> BooleanValidator.NotNull(entity.getId())<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;.constraint(entity -> BooleanValidator.isEmail(entity.getEmail(), Nullable.NOT_NULL));<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;.constraint(entity -> {<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if(entity.getGender == "male") {BooleanValidator.isNull(entity.getPregnant())}<br>
 *          &nbsp;&nbsp;&nbsp;&nbsp;});<br>
 *      </li>
 *      <li>Validating<br>
 *          &nbsp;&nbsp;boolean validationResult = validator.validate(entity);
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
public class ClassBooleanValidator<T> {
    /**
     * The private field to store all the constraint set as a list.
     */
    private List<Function<T, Boolean>> constraints;

    /**
     * Constructor without any argument.
     */
    public ClassBooleanValidator() {
    }

    /**
     * Add a constraint to the validation chain.
     *
     * @param constraint Constraint to be added to the validation chain.<br>
     *                   Constraint must be a Consumer of validation target.
     * @return ChainValidator with the new constraint. This method is intended to be used as a part of the method chain.
     */
    public ClassBooleanValidator<T> constraint(Function<T, Boolean> constraint) {
        if(this.constraints == null) {this.constraints = new LinkedList<>();}
        this.constraints.add(constraint);
        return this;
    }

    /**
     * Run validation process for the target.
     *
     * @param target validation target.
     * @return Validation result.
     */
    public boolean validate(T target) {
        for(Function<T, Boolean> constraint: constraints) {
            if(!constraint.apply(target)) {return false;}
        }
        return true;
    }
}
