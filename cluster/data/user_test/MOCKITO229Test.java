import org.junit.Test;
import org.junit.Ignore;
import org.junit.Before;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

abstract class BaseTest { @Mock protected DaoA dao; }
class DaoA { public void doQuery(){ } } 
class SystemUnderTest 
{ 
    private DaoA dao; 
    public void setDao(DaoA dao) { this.dao = dao; }

    public void businessMethodA() {
        dao.doQuery();
    }
}

public class MOCKITO229Test extends BaseTest
{ 
    @InjectMocks public SystemUnderTest sut;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test1() {
        // sut.setDao(dao); Should not need to run this.
        sut.businessMethodA();
    }     
}
