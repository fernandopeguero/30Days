package com.example.a30days.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30days.R
import com.example.a30days.model.DataRepository
import com.example.a30days.model.Exercise
import com.example.a30days.ui.theme._30DaysTheme


@Composable
fun ExerciseCard(exercise:Exercise, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Card (
        onClick = {
            expanded = !expanded
        },
        modifier = modifier.padding(8.dp)
    ){
        Column(
            modifier = Modifier.padding(
                dimensionResource(R.dimen.padding_small)
            )
        ) {
            Row {
                Text(
                    text = stringResource(R.string.day, exercise.day),
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                )
            }
            Text(
                text = stringResource(exercise.name),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(
                    top = dimensionResource(R.dimen.padding_small),
                    bottom = dimensionResource(R.dimen.padding_small))
            )

            Image(
                painter = painterResource(exercise.imgUrl),
                contentDescription = stringResource( exercise.name),
                contentScale = ContentScale.Crop, 
                modifier = Modifier
                    .sizeIn(maxHeight = 250.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_small)))
            )

            if(expanded){
                ExerciseDescription(stringResource(exercise.description))
            }

        }
    }

}


@Composable
fun ExerciseDescription(description: String , modifier: Modifier = Modifier) {
    Spacer(
        modifier.padding(8.dp)
    )
    Text(
        text = "Description"
    )
    Spacer(
        modifier = Modifier.padding(8.dp)
    )
    Text(
        text = description,
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun ExerciseList(exercises: List<Exercise>, modifier: Modifier = Modifier) {


    LazyColumn(
        modifier = modifier
    ){

        items(
            exercises) {
            ExerciseCard(
                it,
                modifier = Modifier
            )
        }
    }

}

@Composable
fun ExerciseApp(modifier: Modifier = Modifier) {

    val list = DataRepository.exercises

    ExerciseList(list, modifier = modifier)

}


@Preview(showBackground = true)
@Composable
fun PreviewExercise() {
    _30DaysTheme {
        ExerciseApp()
    }
}