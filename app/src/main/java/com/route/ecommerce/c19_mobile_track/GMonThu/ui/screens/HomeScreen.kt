package com.route.ecommerce.c19_mobile_track.GMonThu.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.route.ecommerce.c19_mobile_track.GMonThu.R
import com.route.ecommerce.c19_mobile_track.GMonThu.ui.screens.utils.SearchTextField

@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            CustomBottomNavigationBar(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            when (selectedTab) {
                0 -> HomeScreenContent()
                else -> Box(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun HomeScreenContent(modifier: Modifier = Modifier) {
    HomeScreen(modifier = modifier)
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf("") }
    val typography = MaterialTheme.typography
    val colorScheme = MaterialTheme.colorScheme
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            modifier = Modifier.padding(horizontal = 16.dp),
            contentDescription = stringResource(R.string.app_development_image)
        )

        Row(
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchTextField(
                searchQuery,
                onValueChange = { searchQuery = it },
                leadingIcon = R.drawable.search__2_,
                placeholder = stringResource(R.string.what_do_you_search_for),
                modifier = Modifier
            )
            Spacer(Modifier.weight(1f))

            Image(
                painter = painterResource(R.drawable.card),
                contentDescription = stringResource(R.string.card_image)
            )
        }

        Image(
            painter = painterResource(R.drawable.paper),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(200.dp),
            contentDescription = null
        )

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.categories),
                color = colorScheme.primary,
                style = typography.titleMedium
            )
            Text(
                text = stringResource(R.string.view_all),
                color = colorScheme.primary,
                style = typography.titleSmall
            )
        }

        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            modifier = Modifier.height(288.dp)
        ) {
            items(60) {
                CategoryCard()
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Home Appliance",
            color = colorScheme.primary,
            style = typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(10) {
                HomeApplianceCard()
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun CategoryCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .height(144.dp)
            .width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(R.drawable.dummy),
            contentDescription = null
        )
        Text(stringResource(R.string.headphone))
    }
}

@Composable
fun HomeApplianceCard(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.dummy),
        contentDescription = null,
        modifier = modifier
            .width(158.dp)
            .height(122.dp)
            .clip(RoundedCornerShape(12.dp))
    )
}

@Composable
fun CustomBottomNavigationBar(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    val navBarColor = Color(0xFF004182)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .width(430.dp)
                .height(56.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(navBarColor),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val tabs = listOf(
                R.drawable.home_tab,
                R.drawable.box_tab,
                R.drawable.haert_tab,
                R.drawable.profile_tab
            )

            tabs.forEachIndexed { index, iconRes ->
                val isSelected = selectedTab == index

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(if (isSelected) Color.White else Color.Transparent)
                        .clickable { onTabSelected(index) },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = null,
                        tint = if (isSelected) navBarColor else Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}