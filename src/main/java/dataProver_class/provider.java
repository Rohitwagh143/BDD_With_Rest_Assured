package dataProver_class;

import Pojo.pojo_main;
import Pojo.sub_pojo.Delete;
import Pojo.sub_pojo.Update;
import Pojo.sub_pojo.location;

import java.util.ArrayList;
import java.util.List;

public class provider {

    public static pojo_main objReturn(String name,String language,String address){
        pojo_main p=new pojo_main();
        p.setAccuracy(90);
        p.setName(name);
        p.setPhone_number("(+91) 798 123 4567");
        p.setAddress(address);
        p.setLanguage(language);
        p.setWebsite("https://www.rohit.com/");
        List<String> mylist= new ArrayList<>();
        mylist.add("new place");
        mylist.add("old place");

        p.setTypes(mylist);

        location l=new location();
        l.setLat(-29.123512);
        l.setLng(90.12492);

        p.setLocation(l);
        return p;
    }

    public static Delete delete_(String  place_id)
    {
        Delete d= new Delete();
        d.setPlace_id(place_id);
        return d;
    }
    public static Update Update_(String place_id, String Address){
        Update u=new Update();
        u.setAddress(Address);
        u.setPlace_id(place_id);
        u.setKey("qaclick123");
        return u;
    }
}
