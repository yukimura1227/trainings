// https://doc.rust-jp.rs/book-ja/ch03-01-variables-and-mutability.html
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
}
