static int a = 10 ;
char[] str = "hello world\n";

void[] test;

struct voidStruct{
    void testVoid;
    void[][] testVoid2;
    struct voidStruct testStruct;
};

int c =  a + 1;

typedef unsigned long ulong;

struct test{
    int a;
    char b;
    char a;
    char[] c;
};

typedef struct test TEST1;

ulong aaa;

TEST1 test2;

struct test testA;

int main(int argc, char*[] argv, char** env){
    int i = sizeof argc;
    int j = sizeof(int);
    for( i = 0 ; i < a; i ++){
        if ( i == 0)
            continue;
        if (i == 10)
            break;
    }
    return 0;
}

void func1(){
    main = 1;
}

void func2(){
    int i;
}