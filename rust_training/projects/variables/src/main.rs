// https://doc.rust-jp.rs/book-ja/ch03-01-variables-and-mutability.html
// https://doc.rust-jp.rs/book-ja/ch03-02-data-types.html
fn main() {
    let x = 5;
    println!("The Value Of x is {}", x);
    // 以下はcompileエラーになる。letで宣言したものを変更しようとしているから
    // x = 6;
    // println!("The Value Of x is {}", x);
    let mut y = 5;
    println!("The Value Of y is {}", y);
    y = 6;
    println!("The Value Of y is {}", y);

    let int32 = 2;
    print_type_of(&int32);

    let float64 = 2.0;
    print_type_of(&float64);

    let float32 : f32 = 2.0;
    print_type_of(&float32);

    let boolean = true;
    print_type_of(&boolean);


    let c = 'z';
    print_type_of(&c);
    let z = 'ℤ';
    print_type_of(&z);
    let heart_eyed_cat = '😻';
    print_type_of(&heart_eyed_cat);

    let tupple: (i32, f64, u8) = (500, 6.4, 1);
    print_type_of(&tupple);

    println!("{}", tupple.0);
    println!("{}", tupple.1);
    println!("{}", tupple.2);

    let array = [2,4,6];
    print_type_of(&array);
}
fn print_type_of<T>(_: &T) {
    println!("{}", std::any::type_name::<T>())
}
