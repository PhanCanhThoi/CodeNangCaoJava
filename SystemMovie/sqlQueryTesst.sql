select * from VeXemPhim
select * from LichChieu
select * from Ghe
SELECT g.MaGhe, g.TenGhe, ISNULL(v.TrangThai, 0) AS TinhTrang
FROM Ghe g
LEFT JOIN VeXemPhim v ON g.MaGhe = v.MaGhe AND v.MaLichChieu = 23
WHERE g.MaPhongChieu = 1;
update Ghe
set TrangThai=1
where MaPhongChieu=1
select * 
FROM Ghe g
LEFT JOIN VeXemPhim v ON g.MaGhe = v.MaGhe
