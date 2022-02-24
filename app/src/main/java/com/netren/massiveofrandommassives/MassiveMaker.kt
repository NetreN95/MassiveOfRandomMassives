package com.netren.massiveofrandommassives

import kotlin.math.max


const val MIN_VALUE_OF_MASSIVE = -1024
const val MAX_VALUE_OF_MASSIVE = 1024

const val MIN_SIZE_OF_MASSIVE = 0
const val MAX_SIZE_OF_MASSIVE = 10

class MassiveMaker {
    fun getMassiveOfRandomMassives(n: Int): ArrayList<ArrayList<Int>> {
        val result = arrayListOf<ArrayList<Int>>()

        val sizeCache = arrayListOf<Int>()

        while (result.size < n) {
            result.add(
                getRandomMassiveWithRandomSize(sizeCache = sizeCache)
            )

            //if index of added element is even (2, 4, 6 ...) -> sort ascending (0, 1, 2, 3, 4, 5)
            //if index of added element is odd (1, 3, 5 ...) -> sort descending (5, 4, 3, 2, 1, 0)
            if (result.size % 2 == 0) {
                result[result.size-1].sort()
            } else {
                result[result.size-1].sortDescending()
            }
        }

        return result
    }

    private fun getRandomMassiveWithRandomSize(sizeCache: ArrayList<Int>): ArrayList<Int> {
        var randomSize = 0

        //getting unique size of array
        do {
            randomSize = getRandomSize(
                minSize = MIN_SIZE_OF_MASSIVE,
                maxSize = max(MAX_SIZE_OF_MASSIVE, sizeCache.size + 1)
            )
        } while (sizeCache.contains(element = randomSize))

        //save current size in cache
        sizeCache.add(element = randomSize)

        return getRandomMassiveBySize(size = randomSize)
    }

    private fun getRandomSize(minSize: Int, maxSize: Int): Int {
        return (minSize..maxSize).random()
    }

    private fun getRandomMassiveBySize(size: Int): ArrayList<Int> {
        val result = arrayListOf<Int>()

        while (result.size < size) {
            result.add(
                element = (MIN_VALUE_OF_MASSIVE..MAX_VALUE_OF_MASSIVE).random()
            )
        }

        return result
    }
}