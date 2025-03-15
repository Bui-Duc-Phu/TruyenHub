import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devphu.truyenhub.ui.theme.localtionColors


@Composable
fun LibraryScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(localtionColors.current.backgroup)
        ,
        contentAlignment = Alignment.Center
    ) {

        DanhSachMuc()

    }
}


@Composable
fun DanhSachMuc() {
    val items = List(100) { "Mục số $it" } // Danh sách 100 mục

    LazyColumn {
        items(items) { item ->
            Text(
                text = item,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}

