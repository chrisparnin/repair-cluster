import org.apache.commons.lang3.reflect.TypeUtils;
import org.apache.commons.lang3.reflect.*;
import org.junit.Test;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import javax.lang.model.element.*;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

/**
 * Created by waddl on 2/7/2017.
 */
public class LANG775Test {
    @Test // direct from user
    public void userTest(){
        Map<TypeVariable<?>, Type> typeVarAssigns;
        TypeVariable<?> treeSetTypeVar;
        Type typeArg;

        typeVarAssigns = TypeUtils.getTypeArguments(TypeUtilsTest.Other.class, TypeUtilsTest.This.class);
        Assert.assertEquals(2, typeVarAssigns.size());
        Assert.assertEquals(String.class, typeVarAssigns.get(TypeUtilsTest.This.class.getTypeParameters()[0]));
        Assert.assertEquals(TypeUtilsTest.Other.class.getTypeParameters()[0], typeVarAssigns.get(TypeUtilsTest.This.class.getTypeParameters()[1]));
}}
