package infra.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class EquipmentCodeGenerator {

    public static String generateEquipmentCode(String provider, String category, Date deliveryDate) {
        // Format date to YYYYMMDD
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateStr = dateFormat.format(deliveryDate);

        // Generate a short UUID for uniqueness
        String uniqueId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        // Construct code: first 3 letters of provider + category + date + uniqueId
        String providerCode = provider.replaceAll("\\s+", "").toUpperCase().substring(0, 3);
        String categoryCode = category.replaceAll("\\s+", "").toUpperCase().substring(0, 3);

        return providerCode + "-" + categoryCode + "-" + dateStr + "-" + uniqueId;
    }

//    public static void main(String[] args) {
//        String provider = "TechWorld Ltd";
//        String category = "Router";
//        Date deliveryDate = new Date(); // Use current date or set your own
//
//        String equipmentCode = generateEquipmentCode(provider, category, deliveryDate);
//        System.out.println("Generated Equipment Code: " + equipmentCode);
//    }
}

