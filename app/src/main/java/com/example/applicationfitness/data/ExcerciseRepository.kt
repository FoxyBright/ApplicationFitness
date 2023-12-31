package com.example.applicationfitness.data

import com.example.applicationfitness.R
import com.example.applicationfitness.contracts.ExcerciseContract
import com.example.applicationfitness.models.ExcerciseModel

class ExcerciseRepository: ExcerciseContract.ExcerciseRepository {
    
    private val testExcerList = listOf(
        ExcerciseModel(
            title = "Жим штанги лежа",
            description = "Жим лежа – это многосуставное базовое физическое упражнение с использованием свободных весов (к свободным весам относятся незакрепленные снаряды, такие как штанги, гири, гантели).",
            image = R.drawable.bench,
            id = 1001
        ),
        ExcerciseModel(
            title = "Присед со штангой",
            description = "Приседания со штангой - базовое упражнение в бодибилдинге и пауэрлифтинге, для развития мышц бедра и ягодиц. Атлет, выполняющий упражнение, приседает и затем встаёт со штангой на плечах, возвращаясь в исходное положение стоя. Приседания считаются одним из важнейших упражнений не только в силовом спорте, но и в общефизической подготовке, а также используются в качестве вспомогательного упражнения в процессе подготовки атлетов практически всех видов спорта.",
            image = R.drawable.squat,
            id = 1002
        ),
        ExcerciseModel(
            title = "Армейский жим",
            description = "Армейский жим, или жим штанги стоя – базовая нагрузка, которая развивает мышцы дельт, а так же подключает в работу верхнее отделение спины. При классическом варианте упражнение выполняется из положения стоя.",
            image = R.drawable.ohp,
            id = 1003
        ),
        ExcerciseModel(
            title = "Подъем на бицепс",
            description = "Подъем штанги на бицепс - основное упражнение для увеличения массы бицепса, которые также задействует мышцы предплечья (плечелучевую) и лучезапястные суставы.",
            image = R.drawable.biceps,
            id = 1004
        ),
        ExcerciseModel(
            title = "Становая тяга",
            description = "Становая тяга — базовое (многосуставное) упражнение, выполняемое обычно со штангой, а также с гантелью или гирей, удерживаемыми обеими руками и поднимаемая на уровень опущенных вытянутых рук. Используется как общий элемент физической подготовки и является одной из соревновательных дисциплин в таких видах спорта как пауэрлифтинг и силовой экстрим, применяется также и бодибилдерами для укрепления мышц поясницы, что позволяет в приседаниях лучше развивать ноги.",
            image = R.drawable.deadlift,
            id = 1005
        ),
        ExcerciseModel(
            title = "Отжимания брусья",
            description = "Отжимания на брусьях – широко известное и достаточно доступное упражнение. Брусья стоят практически в каждом дворе, никаких вложений такие занятия не требуют.",
            image = R.drawable.triceps,
            id = 1006
        ),
        ExcerciseModel(
            title = "Подтягивания",
            description = "Подтя́гивания — базовое физическое упражнение, развивающее группы мышц верхней части тела: широчайшие, бицепсы, брахиалис, предплечья. Выполняется в висе и представляет собой поднятие и опускание тела с помощью рук.",
            image = R.drawable.pull,
            id = 1007
        ),
        ExcerciseModel(
            title = "Плечи разводка",
            description = " ",
            image = R.drawable.shoulders,
            id = 1008
        ),
    )
    
    override fun getExcerciseList() = testExcerList
}