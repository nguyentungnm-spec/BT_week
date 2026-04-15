-Tại sao con Vịt (Duck) lại kêu "Animal sound"?
Khi bạn gọi lệnh zoo[i].makeSound(), trình biên dịch sẽ thực hiện cơ chế sau:

Kiểm tra lớp con: Nó sẽ nhìn vào lớp Duck trước để xem có phương thức makeSound() nào được định nghĩa riêng (ghi đè) hay không.

Truy nguyên lên lớp cha: Vì lớp Duck không ghi đè phương thức này, theo tính chất kế thừa, nó sẽ tự động sử dụng "phiên bản" phương thức của lớp cha (Animal).

Kết quả: Do lớp Animal định nghĩa makeSound() là in ra "Animal sound", nên con vịt sẽ kêu như vậy thay vì kêu "Quack quack".