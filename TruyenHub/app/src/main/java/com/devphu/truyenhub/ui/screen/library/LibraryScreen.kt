import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devphu.mycomponent.style.getScreenHeight
import com.devphu.mycomponent.style.getScreenWidth
import com.devphu.truyenhub.R
import com.devphu.truyenhub.ui.screen.MyCollection.component.Toolbar
import com.devphu.truyenhub.ui.screen.library.component.LibraryPager
import com.devphu.truyenhub.ui.screen.library.component.ToolbarLB

import com.devphu.truyenhub.ui.theme.localtionColors


@Composable
fun LibraryScreen(navController: NavController) {
    val weight = getScreenWidth()
    val height = getScreenHeight()
    Box(
        modifier = Modifier.fillMaxSize()
            .background(localtionColors.current.backgroup)
        ,
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top // Đưa item lên top
        ) {
            ToolbarLB()
            LibraryPager()
        }

    }
}


