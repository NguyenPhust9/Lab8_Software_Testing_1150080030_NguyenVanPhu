package vn.lab;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TinhTienNuocTest {

    @Test
    public void testSoM30() {
        // Nhánh Node1 True
        Assert.assertEquals(TinhTienNuoc.tinhTienNuoc(0, "ho_ngheo"), 0);
    }

    @Test
    public void testHoNgheo5m3() {
        // Nhánh Node2 True
        Assert.assertEquals(TinhTienNuoc.tinhTienNuoc(5, "ho_ngheo"), 5*5000);
    }

    @Test
    public void testDanCu8m3() {
        // Nhánh Node4 True
        Assert.assertEquals(TinhTienNuoc.tinhTienNuoc(8, "dan_cu"), 8*7500);
    }

    @Test
    public void testDanCu15m3() {
        // Nhánh Node5 True
        Assert.assertEquals(TinhTienNuoc.tinhTienNuoc(15, "dan_cu"), 15*9900);
    }

    @Test
    public void testDanCu25m3() {
        // Nhánh Node6
        Assert.assertEquals(TinhTienNuoc.tinhTienNuoc(25, "dan_cu"), 25*11400);
    }

    @Test
    public void testKinhDoanh10m3() {
        // Nhánh Node7
        Assert.assertEquals(TinhTienNuoc.tinhTienNuoc(10, "kinh_doanh"), 10*22000);
    }
}