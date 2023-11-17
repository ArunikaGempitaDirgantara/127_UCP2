package com.example.ucp2.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ucp2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    pilihandospem: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onSelectionChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var namaTxt by rememberSaveable {
        mutableStateOf("")
    }
    var NIMTxt by rememberSaveable {
        mutableStateOf("")
    }
    var FokusTxt by rememberSaveable {
        mutableStateOf("")
    }
    var Judul by remember {
        mutableStateOf("")
    }
    var dospemygdipilih by remember {
        mutableStateOf("")
    }

    var listDataTxt: MutableList<String> =
        mutableListOf(namaTxt, NIMTxt, FokusTxt, Judul, dospemygdipilih)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            pilihandospem.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = dospemygdipilih == item,
                        onClick = {
                            dospemygdipilih = item
                            onSelectionChanged(item)
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = dospemygdipilih == item,
                        onClick = {
                            dospemygdipilih = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(item)
                }
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                OutlinedTextField(value = namaTxt, onValueChange = {
                    namaTxt = it
                }, label = {
                    Text(text = "Nama")
                })
                OutlinedTextField(value = NIMTxt, onValueChange = {
                    NIMTxt = it
                }, label = {
                    Text(text = "NIM")
                })
                OutlinedTextField(value = FokusTxt, onValueChange = {
                    FokusTxt = it
                }, label = {
                    Text(text = "Konsentrasi")
                })
                Spacer(modifier = Modifier.padding(16.dp))
                Button(onClick = { onSubmitButtonClicked(listDataTxt) }) {
                    Text(text = stringResource(id = R.string.submit))
                }
            }
        }
    }
}
