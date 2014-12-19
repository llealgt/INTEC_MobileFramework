#import <Foundation/Foundation.h>

@interface Native_CalendarioImpl : NSObject {
}

-(int)agregarEventoCalendarioDefault:(NSString*)param param1:(NSString*)param1 param2:(NSString*)param2 param3:(long long)param3 param4:(long long)param4;
-(int)agregarEventoCalendarioEspecifico:(int)param param1:(NSString*)param1 param2:(NSString*)param2 param3:(NSString*)param3 param4:(long long)param4 param5:(long long)param5;
-(NSString*)obtenerCalendarios;
-(BOOL)isSupported;
@end
