import com.company.Complex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
//import static  org.junit.Assert.*;

/**
 * Created by Admin on 10.07.2016.
 */
public class Testing {

    Complex testObj = new Complex(14,15);
    Complex bObj = new Complex(22,17);
    @Test
public void testValues()
{
    Assert.assertEquals(14.0,testObj.getReal(),0.0);
    Assert.assertEquals(15.0,testObj.getImg(),0.0);
    Assert.assertEquals(22.0,bObj.getReal(),0.0);
    Assert.assertEquals(17.0,bObj.getImg(),0.0);
    //Assert.assertFalse("Must return false if you type chars instead of numbers, for example real = qwe imagine = asd",testObj.checkValue("qwe","asd"));
}
  /*  @Ignore
    @Test
    public void testInsert()
    {
        double[] arr={12,23,35,31};
        //Assert.assertArrayEquals("We want to get real and imagine parts of two complex numbers",arr,(testObj.insert()));
    }

*/
    @Test
    public void testAdd(){
        Assert.assertEquals("36.0+32.0i",testObj.addiction(bObj));
        //Assert.assertEquals(32.0,testObj.dimagine+bObj.dimagine,0.00);
    }
    @Test
    public void testMult(){
        Assert.assertEquals("53.0+568.0i",testObj.multiplication(bObj));
    }
    @Test
    public void testModul(){
        Assert.assertEquals("20.518284528683193i",testObj.modulus());
    }
    @Test
    public void testAmpl(){
        Assert.assertEquals("0.8198672643969563",testObj.amplitude());
    }

}
