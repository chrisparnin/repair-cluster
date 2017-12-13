import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.Answers;

import static org.assertj.core.api.Assertions.assertThat; 

public class MOCKITO99Test 
{

  @Test
  public void test() 
  {
    ToBeMocked mock = mock(ToBeMocked.class, RETURNS_DEEP_STUBS);
    assertThat(mock.getSomething()).isNotNull();
  }

  public static class ToBeMocked 
  {

    NotSerializableReturnValue field1;

    public ToBeMocked(NotSerializableReturnValue field1) {
      this.field1 = field1;
    }

    public NotSerializableReturnValue getSomething() {
      return field1;
    }
  }

  public static class NotSerializableReturnValue {

    String field1 = "";

    public NotSerializableReturnValue(String field1) {
      this.field1 = field1;
    }

    public String getSomething2() {
      return field1;
    }
  }
}
