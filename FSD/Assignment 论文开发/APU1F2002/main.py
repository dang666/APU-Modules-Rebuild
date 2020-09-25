# HE XIAOFENG
# TP059887
import csv
import os
import time
'insert values'
def insert(data):
    f = open('patient_data.txt', 'a', newline='')
    writer = csv.writer(f)
    writer.writerow(data)
    f.close()
def record(data):
    f = open('record_data.txt', 'a', newline='')
    writer = csv.writer(f)
    writer.writerow(data)
    f.close()
def search(id):
    f = open('patient_data.txt', 'r', newline='')
    reader = csv.reader(f)
    for line in reader:
        if line[0]==id:
            f.close()
            return True
    f.close()
    return False
def get_data(id):
    f = open('patient_data.txt', 'r', newline='')
    reader = csv.reader(f)
    for line in reader:
        if line[0] == id:
            f.close()
            return line[4],line[6]
    f.close()
    return 0
def get_rol():
    f = open('patient_data.txt', 'r', newline='')
    reader = csv.reader(f)
    length = 0
    for line in reader:
        length  = length + 1
    f.close()
    f.close()
    return length
def get_ends(test,end,group):
    if test in ['t1','t2']:
        if group in ['ATO','ACC','AEO']:
            if end == '1':
                print('QHNF')
            else:
                print('QDFR')
        elif group =='SID':
            if end == '1':
                print('QHNF')
            else:
                print('HQFR')
        elif group =='AHS':
            if end == '1':
                print('HQNF')
            else:
                print('CWFR')
    elif test == 't3':
        if group in ['ATO','ACC','AEO','SID']:
            if end == '1':
                print('QHNF')
            else:
                print('RU')
        elif group =='AHS':
            if end == '1':
                print('HQNF')
            else:
                print('CW')
def findtest(id):
    f = open('patient_data.txt', 'r', newline='')
    reader = csv.reader(f)
    for line in reader:
        if line[0] == id:
            f.close()
            return line[6]
    f.close()
    return 0
def findCon(id):
    f = open('patient_data.txt', 'r', newline='')
    reader = csv.reader(f)
    for line in reader:
        if line[0] == id:
            if(line[8]=='0'):
                f.close()
                return False
            else:
                f.close()
                return True
    f.close()
    return False
def wConfirmed(data):
    f = open('confirmed_data.txt', 'a', newline='')
    writer=csv.writer(f)
    writer.writerow(data)
    f.close()
def confirmedId():
    f = open('confirmed_data.txt', 'r', newline='')
    reader = csv.reader(f)
    length=0
    for line in reader:
        length+=1
        f.close()
    return length
def findConId(id):
    f = open('confirmed_data.txt', 'r', newline='')
    reader = csv.reader(f)
    for line in reader:
        if line[6] == id:
            f.close()
            return True
    f.close()
    return False
def setState(id,state):
    f = open('confirmed_data.txt', 'r', newline='')
    reader = csv.reader(f)
    f1 = open('confirmed_data.txt', 'w', newline='')
    writer = csv.writer(f1)
    for line in reader:
        if line[6] == id:
            line[5]=state
        writer.writerow(line)
    f.close()
    f1.close()
def getTestName():
    f = open('patient_data.txt', 'r', newline='')
    reader = csv.reader(f)
    t=True
    for line in reader:
        if line[6] != "T0":
            print(line[0]+'  '+line[1])
            t=False
    if t:
        print('no data')
    f.close()
def setinsert(id,test,end):
    f = open('patient_data.txt', 'r', newline='')
    reader = csv.reader(f)
    f1 = open('patient_data.txt', 'w', newline='')
    writer = csv.writer(f1)
    for line in reader:
        if line[0] == id:
            line[6]=test
            line[8]=end
        writer.writerow(line)
    f.close()
    f1.close()
def getTestSum():
    f = open('record_data.txt', 'r', newline='')
    reader = csv.reader(f)
    t11=0
    t10=0
    t21=0
    t20=0
    t30=0
    t31=0
    for line in reader:
        if(line[1]=="T1"):
            if(line[2]=='0'):
                t10+=1
            else:
                t11+=1
        elif(line[1]=='T2'):
            if (line[2] == '0'):
                t20 += 1
            else:
                t21 += 1
        elif(line[1]=='T3'):
            if (line[2] == '0'):
                t30 += 1
            else:
                t31 += 1
    print('T1:positive number:',t11,'negative number:',t10)
    print('T2:positive number:', t21, 'negative number:', t20)
    print('T3:positive number:', t31, 'negative number:', t30)
    f.close()
def getRestore():
    f = open('confirmed_data.txt', 'r', newline='')
    reader = csv.reader(f)
    t=True
    for line in reader:
        if line[5] == "RECOVERED":
            print(line[0],line[2],line[3],sep='/')
            t=False
    if t:
        print('no data')
    f.close()
def getZoneNum():
    f = open('confirmed_data.txt', 'r', newline='')
    reader = csv.reader(f)
    a=0
    b=0
    c=0
    d=0
    for line in reader:
        if line[3]=="SID":
            if line[2] == "A":
                a+=1
            elif line[2]=="B":
                b+=1
            elif line[2]=="C":
                c+=1
            elif line[2]=="D":
                d+=1
    print('Covid - 19 groups of the patients who tested positive for the partition:a:',a,'b:',b,'c:',c,'d:',d)
    f.close()
def getACZoneNum():
    f = open('confirmed_data.txt', 'r', newline='')
    reader = csv.reader(f)
    a = 0
    b = 0
    c = 0
    d = 0
    for line in reader:
        if line[5] == "ACTIVE":
            if line[2] == "A":
                a += 1
            elif line[2] == "B":
                b += 1
            elif line[2] == "C":
                c += 1
            elif line[2] == "D":
                d += 1
    print('Cases of activity partition:a:', a, 'b:', b, 'c:', c, 'd:', d)
    f.close()
def getdel():
    f = open('confirmed_data.txt', 'r', newline='')
    reader = csv.reader(f)
    t=False
    for line in reader:
        if line[5] == "DECEASED":
            t=True
            print(line[0],line[1],line[2],line[3],line[4],line[5],line[6],sep='/')
    if not t:
        print('no data')
    f.close()
def findcase(id):
    f = open('confirmed_data.txt', 'r', newline='')
    reader = csv.reader(f)
    for line in reader:
        if line[6] == id:
            print(line[5])
            break
    f.close()
def getname(name):
    f = open('confirmed_data.txt', 'r', newline='')
    reader = csv.reader(f)
    for line in reader:
        if line[7] == name:
            print(line[5])
            break
    print('can\'t find')
    f.close()
def findname(id):
    f = open('patient_data.txt', 'r', newline='')
    reader = csv.reader(f)
    for line in reader:
        if line[0] == id:
            f.close()
            return line[1]
    f.close()
    return 0
def menu():
    operation = input('''please input operat
        1: insert values 
        2: get ends
        3: Set the patients condition
        4: The test statistics
        5: What to search
        0: exit 
        ''')
    return operation
def menu1():
    printsum = input('''Please input to query:
        1: The test
        2: Patients receiving inspection
        3: Restore the case
        4: Patients were detected positive partition
        5: The partition activity cases
        0: exit 
        ''')
    return printsum
def menu2():
    printsum = input('''What to search
        1:what to name
        2:ID to now
        3:all deceased
        0: exit ''')
    return printsum


def main():
    zone1=['A','B','C','D'] 
    group1=['ATO','ACC','AEO','SID','AHS']
    tt=['T1','T2','T3']
    print('Welcome to use COVID19 management system Please login')
    p=True;
    while p:
        pwd=int(input('enter password:'))
        if pwd==123:
            p=False
            print('welcome root')
            time.sleep(1)
            os.system('cls')
        else:
            print('wrong password')

    data = []
    f = open('patient_data.txt', 'w', newline='')
    writer = csv.writer(f)
    # writer.writerow(['id','name', 'phone', 'mail', 'zone', 'group','testTimes', 'height','confirmed'])
    f.close()

    f = open('record_data.txt', 'w', newline='')
    writer = csv.writer(f)
    # writer.writerow(['id','test_period','ends','zone','group'])
    f.close()
    f = open('confirmed_data.txt', 'w', newline='')
    writer = csv.writer(f)
    f.close()
    temp_data = []
    operation = menu()
    while (operation != '0'):
        if operation == '1':
            id = get_rol()
            print('please input patient\'s  name phone mail zone group and height:')

            name = input('name')
            phone = input('phone')
            mail = input('mail')
            zone='0'
            while zone not in zone1:
                zone = input('zone for A,B,C,D:')
            group='0'
            while group not in group1:
                group = input('group for ATO ACC AEO SID AHS')
            testTimes = 'T0'
            height = input('height')
            confirmed = '0'
            insert([id, name, phone, mail, zone, group, testTimes, height, confirmed])
            operation = menu()
        elif operation == '2':
            print('please input patient\'s id test_period ends:')

            id = input('id')
            test='0'
            while test not in tt:
                test = input('test for T1 T2 T3')
            boolend=['0','1']
            end='sssss'
            while end not in boolend:
                end = input('end for 1 or 0')
            print(id, test, end)
            if search(id):
                if (findCon(id)):
                    print('Confirmed the patient should not be tested')
                    operation = menu()
                tNum = findtest(id)
                if ((tNum == "T0" and test == "T1") or (tNum == "T1" and test == "T2") or (
                        tNum == "T2" and test == "T3")):

                    zone, group = get_data(id)
                    setinsert(id, test, end)
                    record([id, test, end, zone, group])
                    get_ends(test, end, group)
                    if (end == '1'):
                        ward = input('The patient has been confirmed, please will arrange in the NM or ICU')
                        state = 'ACTIVE'
                        conid = confirmedId()
                        print('Cases of the patients with ID:', conid)
                        name=findname(id)
                        wConfirmed([id, test, zone, group, ward, state, conid,name])
                else:
                    print('Before the patient didn\'t finish the test, the order according to the patient\'s detection')
                    print('Now the patient has completed testing %s' % tNum)
                    operation = menu()
            else:
                print('Don\'t find this id,please try it again!\n')
            operation = menu()
        elif operation == '3':
            print('Please enter the patient ID and the modified state:')

            id = input('id')
            state = input('state')
            if (findConId(id)):
                setState(id, state)
            else:
                print('I\'m sorry, but we didn\'t find the patient, should be confirmed yet')
            operation = menu()
        elif operation == '4':
            printsum = menu1()
            while (printsum != '0'):
                if (printsum == '1'):
                    getTestSum()
                    printsum = menu1()
                elif (printsum == '2'):
                    getTestName()
                    printsum = menu1()
                elif (printsum == '3'):
                    getRestore()
                    printsum = menu1()
                elif (printsum == '4'):
                    getZoneNum()
                    printsum = menu1()
                elif (printsum == '5'):
                    getACZoneNum()
                    printsum = menu1()
            operation = menu()
        elif operation == '5':
            printsum = menu2()
            while (printsum != '0'):
                if (printsum == '1'):
                    name=input('check the patient record by name')
                    getname(name)
                    printsum = menu2()
                elif(printsum == '2'):
                    id=input('case ID:')
                    findcase(id)
                    printsum = menu2()
                elif(printsum == '3'):
                    getdel()
                    printsum = menu2()
                else:
                    printsum = menu2()
            operation = menu()


if __name__ == '__main__':
    main()

