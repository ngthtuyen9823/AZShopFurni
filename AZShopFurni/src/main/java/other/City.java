package other;

import java.util.ArrayList;
import java.util.List;

public enum City {
    HA_NOI("Hà Nội"),
    HO_CHI_MINH("Hồ Chí Minh"),
    DA_NANG("Đà Nẵng"),
    HAI_PHONG("Hải Phòng"),
    HUE("Huế"),
    CAN_THO("Cần Thơ"),
    NHA_TRANG("Nha Trang"),
    VINH("Vinh"),
    QUY_NHON("Quy Nhơn"),
    VUNG_TAU("Vũng Tàu"),
    HA_LONG("Hạ Long"),
    PHAN_THIET("Phan Thiết"),
    RACH_GIA("Rạch Giá"),
    THAI_NGUYEN("Thái Nguyên"),
    BUON_MA_THUOT("Buôn Ma Thuột"),
    BIEN_HOA("Biên Hòa"),
    LAO_CAI("Lào Cai"),
    LONG_XUYEN("Long Xuyên"),
    MY_THO("Mỹ Tho"),
    NAM_DINH("Nam Định"),
    PHAN_RANG("Tháp Chàm"),
    TAM_KY("Tam Kỳ"),
    TAN_AN("Tân An"),
    THANH_HOA("Thanh Hóa"),
    TUY_HOA("Tuy Hòa"),
    UONG_BI("Uông Bí"),
    YEN_BAI("Yên Bái"),
    SA_DEC("Sa Đéc"),
    SON_LA("Sơn La"),
    HA_TINH("Hà Tĩnh"),
    CAM_RANH("Cam Ranh"),
    QUANG_NGAI("Quảng Ngãi"),
    CHAU_DOC("Châu Đốc"),
    BAC_LIEU("Bạc Liêu"),
    TUYEN_QUANG("Tuyên Quang"),
    BAC_NINH("Bắc Ninh"),
    HA_DONG("Hà Đông"),
    BAC_GIANG("Bắc Giang"),
    DONG_HOI("Đồng Hới"),
    VI_THANH("Vị Thanh"),
    CA_MAU("Cà Mau"),
    HA_GIANG("Hà Giang"),
    DONG_THAP("Đồng Tháp"),
    SON_TAY("Sơn Tây"),
    THAI_BINH("Thái Bình"),
    NINH_BINH("Ninh Bình"),
    PHU_QUOC("Phú Quốc"),
    TRÀ_VINH("Trà Vinh"),
    SONG_CAU("Sóc Trăng"),
    BAC_CAN("Bắc Cạn"),
    HA_TIEN("Hà Tiên"),
    SON_MY("Sơn Mỹ"),
    GIA_LAII("Gia Lai"),
    THANH_CHUONG("Thanh Chương"),
    THANH_XUAN("Thanh Xuân"),
    HAI_DUONG("Hải Dương"),
    QUANG_NAM("Quảng Nam"),
    KIEN_GIANG("Kiên Giang"),
    HA_NAM("Hà Nam"),
    CUA_LO("Cửa Lò"),
    LUC_NAM("Lục Nam"),
    NINH_BÌNH("Ninh Bình"),
    PHUC_YEN("Phúc Yên"),
    CAO_BẰNG("Cao Bằng"),
    ;

    private final String vietnameseName;

    City(String vietnameseName) {
        this.vietnameseName = vietnameseName;
    }

    public String getVietnameseName() {
        return vietnameseName;
    }
    
	public static List<String> getListCity(){
    	List<String> listcity = new ArrayList<String>();
    	for (City city : City.values()) {
    		listcity.add(city.getVietnameseName());
        }
    	return listcity;
    }
}

