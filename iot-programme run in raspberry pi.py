import urllib2
import demjson
import time
import traceback

pin_val=[0,0,0,0,0,0,0,0,0,0,0,0]
def getPin(pin):
    return pin_val[pin]
def setPin(pin,value):
    pin_val[pin]=value

while(True):
    time.sleep(5)
    print(pin_val)
    print("*************************************************")
    #check for command
    for i in range(0,7):
        try:
            response = urllib2.urlopen('http://mobileiot.16mb.com/index.php/Mobile/mobiledownload/'+str(i))
            html = response.read()
            html=html.split("#")[1]
            #print(html)
            text = demjson.decode(html)
            pin=text['pin_out']
            print(pin,"    ",text['status'])
            
        except:
            print("Error detected IN FETCHING STATUS ")
            text={'executed':-1}
            #traceback.print_exc(file=sys.stdout)
        
        if (int(text['executed'])==1):   #if command execute and set new value
             
            try:
                cur=str(getPin(int(pin)))
                response = urllib2.urlopen('http://mobileiot.16mb.com/index.php/Mobile/mobileupload/'+pin+'/'+cur+'/'+str(1))
                html = response.read()
                html=html.split("#")[0]       
                text = demjson.decode(html)
                
            except:
                print("Error detected EXECUTE WITHOUT UPDATE")
                text={'executed':-1}
        elif(int(text['executed'])==0):  #if not command set new value 
            #execute command
            
            try:
                value=int(text['new_value'])
                setPin(int(pin),value)
                pin_value=str(getPin(int(pin)))
                response = urllib2.urlopen('http://mobileiot.16mb.com/index.php/Mobile/mobileupload/'+pin+'/'+pin_value+'/'+str(1))
                html = response.read()
                html=html.split("#")[0]
                text = demjson.decode(html)
            except:
                print("Error detected EXECUTE WITH UPDATE")
                text={'executed':-1}
       
        


