import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;


public class ItemController {
    private ItemService itemService = new ItemService();

    Item save(Item item)  {


        try {
            return itemService.save(item);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    void delete(long id) {

        try {
            itemService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Item findById(long id) {

        try {
            return itemService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    Item update(Item item, long id) {

        try {
            return itemService.update(item, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    Item mapJSONtoItem(BufferedReader br) {


        ObjectMapper mapper = new ObjectMapper();
        try {


            Item item = mapper.readValue(br, Item.class);

            return item;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    boolean isIdExists(long id){

        return itemService.isIdExists(id);
    }




}
