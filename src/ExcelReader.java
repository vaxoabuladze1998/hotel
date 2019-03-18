import models.Hotel;
import models.Room;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public static List<Hotel> getData() throws IOException {
        List<Hotel> hotels = new ArrayList<>();

        Workbook workbook = WorkbookFactory.create(new File("C:/Users/Davit/Desktop/Hotel-Booking.xlsx"));


        Sheet sheet = workbook.getSheetAt(0);

        for(int rn =1; rn<= sheet.getLastRowNum(); rn++){
            Row r = sheet.getRow(rn);
            Hotel hotel = new Hotel();

            for(int cn = 1; cn<r.getLastCellNum(); cn++){
                Cell c = r.getCell(cn);

                switch (cn){
                    case 1:
                        hotel.setName(c.getStringCellValue());
                        break;
                    case 2:
                        hotel.setCountry(c.getStringCellValue());
                        break;
                    case 3:
                        hotel.setCity(c.getStringCellValue());
                        break;
                    case 4:
                        hotel.setStars(c.getNumericCellValue());
                        break;
                }
            }
            hotels.add(hotel);

        }

        sheet = workbook.getSheetAt(1);

        for(int rn=1; rn<=sheet.getLastRowNum(); rn++){
            Row r = sheet.getRow(rn);
            Room room = new Room();

            for(int cn=0; cn<r.getLastCellNum(); cn++){
                Cell c =r.getCell(cn);

                switch (cn){
                    case 0:
                        room.setNumber(c.getNumericCellValue());
                        break;
                    case 1:
                        room.setPrice(c.getNumericCellValue());
                        break;
                    case 2:
                        int hotelId = (int)Math.floor(c.getNumericCellValue());
                        room.setHotelId(hotelId);
                        hotels.get(hotelId-1).addRoom(room);
                        break;
                }
            }
        }

        workbook.close();

        return hotels;
    }
}
