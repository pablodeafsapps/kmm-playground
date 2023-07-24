package org.deafsapps.kmm.kmmplayground.android.character.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.deafsapps.kmm.kmmplayground.android.R
import org.deafsapps.kmm.kmmplayground.character.domain.model.Character

@Composable
fun MainScreen(
    list: List<Character>,
    onCharacterSelected: (Character) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = colorResource(id = android.R.color.background_light))
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.characters),
            color = colorResource(id = android.R.color.darker_gray),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.h6,
            maxLines = 1,
            modifier = modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )
        val listState = rememberLazyListState()
        LazyColumn(
            state = listState,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(items = list, key = { item -> item.id }) { character ->
                Text(text = character.name,
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { onCharacterSelected(character) })
            }
        }
        LaunchedEffect(key1 = listState, block = {
            listState.animateScrollToItem(list.size)
        })
    }
}