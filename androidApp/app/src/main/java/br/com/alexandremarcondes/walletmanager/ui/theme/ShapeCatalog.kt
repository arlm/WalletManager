package br.com.alexandremarcondes.walletmanager.ui.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubtypeOf
import kotlin.reflect.typeOf

class ShapeCatalog<out T : CornerBasedShape> {
    private var _full: T? = null
    private var _top: T? = null
    private var _bottom: T? = null
    private var _start: T? = null
    private var _end: T? = null
    private var _topStartBottomEnd: T? = null
    private var _bottomStartTopEnd: T? = null

    val full: T get() = _full!!
    val top: T get() = _top!!
    val bottom: T get() = _bottom!!
    val start: T get() = _start!!
    val end: T get() = _end!!
    val topStartBottomEnd: T get() = _topStartBottomEnd!!
    val bottomStartTopEnd: T get() = _bottomStartTopEnd!!

    private constructor()

    constructor(clazz: KClass<T>, dp: Dp) : this() {
        _full = create(
            clazz,
            topStart = CornerSize(dp),
            topEnd = CornerSize(dp),
            bottomEnd = CornerSize(dp),
            bottomStart = CornerSize(dp)
        )

        _top = create(
            clazz,
            topStart = CornerSize(dp),
            topEnd = CornerSize(dp),
            bottomEnd = CornerSize(0.dp),
            bottomStart = CornerSize(0.dp)
        )

        _bottom = create(
            clazz,
            topStart = CornerSize(0.dp),
            topEnd = CornerSize(0.dp),
            bottomEnd = CornerSize(dp),
            bottomStart = CornerSize(dp)
        )

        _start = create(
            clazz,
            topStart = CornerSize(dp),
            topEnd = CornerSize(0.dp),
            bottomEnd = CornerSize(0.dp),
            bottomStart = CornerSize(dp)
        )

        _end = create(
            clazz,
            topStart = CornerSize(0.dp),
            topEnd = CornerSize(dp),
            bottomEnd = CornerSize(dp),
            bottomStart = CornerSize(0.dp)
        )

        _topStartBottomEnd = create(
            clazz,
            topStart = CornerSize(dp),
            topEnd = CornerSize(0.dp),
            bottomEnd = CornerSize(dp),
            bottomStart = CornerSize(0.dp)
        )

        _bottomStartTopEnd = create(
            clazz,
            topStart = CornerSize(0.dp),
            topEnd = CornerSize(dp),
            bottomEnd = CornerSize(0.dp),
            bottomStart = CornerSize(dp)
        )
    }

    constructor(clazz: KClass<T>, percent: Int) : this() {
        _full = create(
            clazz,
            topStart = CornerSize(percent),
            topEnd = CornerSize(percent),
            bottomEnd = CornerSize(percent),
            bottomStart = CornerSize(percent)
        )

        _top = create(
            clazz,
            topStart = CornerSize(percent),
            topEnd = CornerSize(percent),
            bottomEnd = CornerSize(0),
            bottomStart = CornerSize(0)
        )

        _bottom = create(
            clazz,
            topStart = CornerSize(0),
            topEnd = CornerSize(0),
            bottomEnd = CornerSize(percent),
            bottomStart = CornerSize(percent)
        )

        _start = create(
            clazz,
            topStart = CornerSize(percent),
            topEnd = CornerSize(0),
            bottomEnd = CornerSize(0),
            bottomStart = CornerSize(percent)
        )

        _end = create(
            clazz,
            topStart = CornerSize(0),
            topEnd = CornerSize(percent),
            bottomEnd = CornerSize(percent),
            bottomStart = CornerSize(0)
        )

        _topStartBottomEnd = create(
            clazz,
            topStart = CornerSize(percent),
            topEnd = CornerSize(0),
            bottomEnd = CornerSize(percent),
            bottomStart = CornerSize(0)
        )

        _bottomStartTopEnd = create(
            clazz,
            topStart = CornerSize(0),
            topEnd = CornerSize(percent),
            bottomEnd = CornerSize(0),
            bottomStart = CornerSize(percent)
        )
    }

    private fun <C : CornerBasedShape> create(
        clazz: KClass<C>,
        topStart: CornerSize,
        topEnd: CornerSize,
        bottomEnd: CornerSize,
        bottomStart: CornerSize
    ): C {
        val constructor = clazz.constructors.first { constructor ->
            constructor.parameters.size == 4
                    && constructor.parameters.all {
                it.type.isSubtypeOf(typeOf<CornerSize>())
            }
        }

        return constructor.call(
            topStart,
            topEnd,
            bottomEnd,
            bottomStart
        )
    }
}