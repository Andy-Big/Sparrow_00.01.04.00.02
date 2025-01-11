package com.rigol.scope.utilities;

import com.rigol.scope.utilities.GenericBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public class GenericBuilder<T> {
    private final Supplier<T> instantiator;
    private final List<Consumer<T>> instantiatorModifiers = new ArrayList();
    private final List<Consumer<T>> keyValueModifiers = new ArrayList();

    public GenericBuilder(Supplier<T> supplier) {
        this.instantiator = supplier;
    }

    public static <T> GenericBuilder<T> of(Supplier<T> supplier) {
        return new GenericBuilder<>(supplier);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.utilities.-$$Lambda$GenericBuilder$8owpsoiHvS8lABEF5di8Ms_Sijs.accept(java.lang.Object):void] */
    static /* synthetic */ void lambda$with$0(BiConsumer biConsumer, Object obj, Object obj2) {
        biConsumer.accept(obj2, obj);
    }

    public <U> GenericBuilder<T> with(final BiConsumer<T, U> biConsumer, final U u) {
        this.instantiatorModifiers.add(new Consumer() { // from class: com.rigol.scope.utilities.-$$Lambda$GenericBuilder$8owpsoiHvS8lABEF5di8Ms_Sijs
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                GenericBuilder.lambda$with$0(biConsumer, u, obj);
            }
        });
        return this;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.utilities.-$$Lambda$GenericBuilder$sAGrN092yahs4PpYq7S2T93GUP8.accept(java.lang.Object):void] */
    static /* synthetic */ void lambda$with$1(KeyValueConsumer keyValueConsumer, Object obj, Object obj2, Object obj3) {
        keyValueConsumer.accept(obj3, obj, obj2);
    }

    public <K, V> GenericBuilder<T> with(final KeyValueConsumer<T, K, V> keyValueConsumer, final K k, final V v) {
        this.keyValueModifiers.add(new Consumer() { // from class: com.rigol.scope.utilities.-$$Lambda$GenericBuilder$sAGrN092yahs4PpYq7S2T93GUP8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                GenericBuilder.lambda$with$1(GenericBuilder.KeyValueConsumer.this, k, v, obj);
            }
        });
        return this;
    }

    public T build() {
        final T t = this.instantiator.get();
        this.instantiatorModifiers.forEach(new Consumer() { // from class: com.rigol.scope.utilities.-$$Lambda$GenericBuilder$YpsHaZdEv__3UrED7n2RblPPNVI
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                GenericBuilder.lambda$build$2(t, (Consumer) obj);
            }
        });
        this.keyValueModifiers.forEach(new Consumer() { // from class: com.rigol.scope.utilities.-$$Lambda$GenericBuilder$-5gnxTGT3i1s7y3vNgb3sY8cods
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                GenericBuilder.lambda$build$3(t, (Consumer) obj);
            }
        });
        this.instantiatorModifiers.clear();
        this.keyValueModifiers.clear();
        return t;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.utilities.-$$Lambda$GenericBuilder$YpsHaZdEv__3UrED7n2RblPPNVI.accept(java.lang.Object):void] */
    static /* synthetic */ void lambda$build$2(Object obj, Consumer consumer) {
        consumer.accept(obj);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.utilities.-$$Lambda$GenericBuilder$-5gnxTGT3i1s7y3vNgb3sY8cods.accept(java.lang.Object):void] */
    static /* synthetic */ void lambda$build$3(Object obj, Consumer consumer) {
        consumer.accept(obj);
    }

    @FunctionalInterface
    /* loaded from: classes2.dex */
    interface KeyValueConsumer<T, K, V> {
        void accept(T t, K k, V v);

        default KeyValueConsumer<T, K, V> andThen(final KeyValueConsumer<? super T, ? super K, ? super V> keyValueConsumer) {
            Objects.requireNonNull(keyValueConsumer);
            return new KeyValueConsumer() { // from class: com.rigol.scope.utilities.-$$Lambda$GenericBuilder$KeyValueConsumer$6mQ2hjurq_2TBLO9DxwP07dSoWM
                @Override // com.rigol.scope.utilities.GenericBuilder.KeyValueConsumer
                public final void accept(Object obj, Object obj2, Object obj3) {
                    GenericBuilder.KeyValueConsumer.lambda$andThen$0(GenericBuilder.KeyValueConsumer.this, keyValueConsumer, obj, obj2, obj3);
                }
            };
        }

        static /* synthetic */ void lambda$andThen$0(KeyValueConsumer _this, KeyValueConsumer keyValueConsumer, Object obj, Object obj2, Object obj3) {
            _this.accept(obj, obj2, obj3);
            keyValueConsumer.accept(obj, obj2, obj3);
        }
    }
}
