package com.example.ucp2.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.ucp2.R
import com.example.ucp2.data.SkripsiUIState

@Composable
fun HalamanDua (
    SkripsiUIState: SkripsiUIState,
    onCancelButtonClicked: () -> Unit,
    //onSendButtonClicked: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        Pair(stringResource(R.string.nama), SkripsiUIState.nama),
        Pair(stringResource(R.string.nim), SkripsiUIState.nim),
        Pair(stringResource(R.string.fokus), SkripsiUIState.fokus),
        Pair(stringResource(R.string.judul), SkripsiUIState.judul),
        Pair(stringResource(R.string.dsn1), SkripsiUIState.dospem),
        Pair(stringResource(R.string.dsn2), SkripsiUIState.dospem),
        Pair(stringResource(R.string.dsn3), SkripsiUIState.dospem)
    )

    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column (
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ){
            items.forEach { item ->
                Column {
                    Text(item.first.uppercase())
                    Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
                }
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small))
            )
        }
        Row (
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(R.dimen.padding_medium))
        ){
            Column (
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ){
                Button( modifier =  Modifier
                    .fillMaxWidth(),
                    onClick = { }
                ) {
                    Text(stringResource(R.string.send))
                }
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onCancelButtonClicked}
                ) {
                    Text(stringResource(R.string.cancel))
                }
            }
        }
    }
}