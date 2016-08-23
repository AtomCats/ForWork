import com.company.LinkedListImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

/**
 * Created by Admin on 20.08.2016.
 */
public class Testing {
    LinkedListImpl<Integer> myList = new LinkedListImpl<>();
    Iterator<Integer> itr= myList.iterator();
    int test;
    Random r = new Random(15);


    @Before
    public void prepare(){
        for(int i=0;i<10;i++){
        myList.add(r.nextInt());
        }

    }
    @Test
    public void addGetTest(){
    myList.add((int)55);
        Assert.assertEquals(55,myList.get(11));
    }

    @Test
    public void size(){
        Assert.assertEquals(10,myList.size());
    }

    @Test
    public void emptinessTest(){
        Assert.assertEquals(false,myList.isEmpty());
    }

    @Test
    public void removeTest(){
        try{
            myList.get(10);
        }
        catch (Exception e){
            Assert.assertEquals(e,myList.get(10));
        }
    }
}

