package com.devphu.truyenhub.ui.theme


import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

// Data class chứa các chuỗi ứng với từng ngôn ngữ
@Immutable
data class AppStrings(
    val appName: String,
    val theloai: String,
    val searchHint: String,
    val listLabel: String,
    val male: String,
    val feMale: String,
    // Thêm các chuỗi khác nếu cần
)
// Tạo CompositionLocal để cung cấp chuỗi
val LocalAppStrings = staticCompositionLocalOf {
    AppStrings(
        appName = "",
        theloai = "",
        searchHint = "",
        listLabel = "",
        male = "",
        feMale = "",
    )
}
// Bộ chuỗi cho tiếng Việt
val VietnameseStrings = AppStrings(
    appName = "Truyện Hub",
    theloai = "Thể Loại",
    searchHint = "Tìm kiếm",
    listLabel = "Danh sách",
    male = "Nam",
    feMale = "Nữ",
)

// Bộ chuỗi cho tiếng Anh
val EnglishStrings = AppStrings(
    appName = "Story Hub",
    theloai = "Thể Loại",
    searchHint = "Search",
    listLabel = "List",
    male = "Nam",
    feMale = "Nữ",
)

