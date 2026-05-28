# Chuẩn hóa mã lỗi HTTP (HTTP Status Codes)

## TH1: Người dùng gửi yêu cầu đặt lịch khám nhưng bỏ trống tên bệnh nhân

### Mã lỗi phù hợp:

```http
400 Bad Request
```

### Giải thích:

* Request được gửi lên không hợp lệ vì thiếu dữ liệu bắt buộc (`patientName`).
* Đây là lỗi từ phía client gửi sai dữ liệu.

### Ví dụ:

```json
{
  "error": "Patient name is required"
}
```

---

## TH2: Tìm kiếm hồ sơ bệnh án với ID = 999 nhưng Database không tồn tại

### Mã lỗi phù hợp:

```http
404 Not Found
```

### Giải thích:

* Request đúng cú pháp nhưng tài nguyên không tồn tại.
* Hệ thống không tìm thấy hồ sơ bệnh án với ID yêu cầu.

### Ví dụ:

```json
{
  "error": "Medical record not found"
}
```

---

## TH3: Database MySQL bị sập, không thể truy vấn dữ liệu

### Mã lỗi phù hợp:

```http
500 Internal Server Error
```

### Giải thích:

* Đây là lỗi phía server.
* Người dùng gửi request đúng nhưng hệ thống backend gặp sự cố nội bộ.

### Ví dụ:

```json
{
  "error": "Internal server error"
}
```

---

## TH4: Người dùng nhập tuổi bệnh nhân = -5

### Mã lỗi phù hợp:

```http
400 Bad Request
```

### Giải thích:

* Dữ liệu gửi lên sai logic nghiệp vụ.
* Tuổi không thể là số âm nên request không hợp lệ.

### Ví dụ:

```json
{
  "error": "Age must be greater than or equal to 0"
}
```

---

# Tổng kết

| Tình huống                    | HTTP Status Code          | Ý nghĩa                      |
| ----------------------------- | ------------------------- | ---------------------------- |
| Thiếu tên bệnh nhân           | 400 Bad Request           | Dữ liệu gửi lên không hợp lệ |
| Không tìm thấy hồ sơ ID = 999 | 404 Not Found             | Tài nguyên không tồn tại     |
| Database bị sập               | 500 Internal Server Error | Lỗi hệ thống phía server     |
| Tuổi = -5                     | 400 Bad Request           | Sai dữ liệu logic            |

---

# Ghi nhớ nhanh

* `400 Bad Request` → Client gửi dữ liệu sai
* `404 Not Found` → Không tìm thấy tài nguyên
* `500 Internal Server Error` → Lỗi hệ thống server
