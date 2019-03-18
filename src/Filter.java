import models.Hotel;
import models.Room;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    public static List<Hotel> filterHotels(List<Hotel> hotels, String country, String city, double stars){
        List<Hotel> filteredHotels = new ArrayList<>();

        for (Hotel hotel: hotels){
            if(country.equals(hotel.getCountry())){
                filteredHotels.add(hotel);
            }
            if(city.equals(hotel.getCity())){
                filteredHotels.add(hotel);
            }
            if(stars == hotel.getStars()){
                filteredHotels.add(hotel);
            }
        }

        return filteredHotels;
    }

    public static List<Room> filterRooms(List<Hotel> hotels, double price){
        List<Room> filteredRooms = new ArrayList<>();

        for(Hotel hotel: hotels){
            for(Room room: hotel.getRooms()){
                if(price == room.getPrice()){
                    filteredRooms.add(room);
                }
            }
        }

        return filteredRooms;
    }
}
