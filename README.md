🚀 Hướng dẫn Import Project Android vào Android Studio
Làm theo các bước sau để mở project Android trong Android Studio:

✅ Bước 1: Clone dự án về máy
Sử dụng Git để clone repository về máy bạn:
```bash
https://github.com/Thangtn52751/SimpleJetpackcomposeRecipe
```
```bash
git clone https://github.com/Thangtn52751/SimpleJetpackcomposeRecipe.git
```
Hoặc nếu bạn đã tải file ZIP, hãy giải nén nó ra thư mục mong muốn.

✅ Bước 2: Mở Android Studio
Mở Android Studio.

Tại màn hình chính, chọn "Open an Existing Project".

Duyệt tới thư mục chứa mã nguồn dự án (thư mục đã clone hoặc giải nén).

Nhấn OK để mở dự án.

✅ Bước 3: Chờ Gradle Sync
Sau khi mở, Android Studio sẽ tự động tiến hành Gradle Sync. Nếu không:

Chọn File > Sync Project with Gradle Files.

Lưu ý: Đảm bảo bạn đã cài đặt phiên bản Android Studio và SDK tương thích với dự án.

✅ Bước 4: Chạy dự án
Kết nối thiết bị thật hoặc mở trình giả lập (AVD).

Nhấn nút Run (▶️) trên thanh công cụ hoặc chọn Run > Run 'app'.

🔧 Lưu ý
Nếu gặp lỗi thiếu thư viện, hãy kiểm tra file build.gradle và đảm bảo tất cả dependencies được tải thành công.

Nếu sử dụng API hoặc Firebase, bạn có thể cần tạo file google-services.json hoặc cấu hình .env theo hướng dẫn riêng.

📌 Yêu cầu hệ thống:

Android Studio Bumblebee trở lên

JDK 11 trở lên

Android SDK phù hợp với minSdk và targetSdk của dự án

