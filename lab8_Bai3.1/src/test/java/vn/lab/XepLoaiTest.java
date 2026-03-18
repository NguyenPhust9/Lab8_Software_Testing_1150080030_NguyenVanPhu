package vn.lab;

import org.testng.Assert;
import org.testng.annotations.Test;

public class XepLoaiTest {

    @Test
    public void testDiemKhongHopLe() {
        Assert.assertEquals(XepLoai.xepLoai(-1, true), "Diem khong hop le");
    }

    @Test
    public void testGioi() {
        Assert.assertEquals(XepLoai.xepLoai(9, false), "Gioi");
    }

    @Test
    public void testKha() {
        Assert.assertEquals(XepLoai.xepLoai(7, false), "Kha");
    }

    @Test
    public void testTrungBinh() {
        Assert.assertEquals(XepLoai.xepLoai(6, false), "Trung Binh");
    }

    @Test
    public void testThiLai() {
        Assert.assertEquals(XepLoai.xepLoai(4, true), "Thi lai");
    }

    @Test
    public void testYeuHocLai() {
        Assert.assertEquals(XepLoai.xepLoai(4, false), "Yeu - Hoc lai");
    }
}