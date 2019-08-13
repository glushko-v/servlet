public class ItemController {
    private ItemService itemService = new ItemService();

    Item save(Item item) {


        try {
            return itemService.save(item);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    void delete(long id)  {

        try {
            itemService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Item findById(long id)  {

        try {
            return itemService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    Item update(Item item)  {

        try {
            return itemService.update(item);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
