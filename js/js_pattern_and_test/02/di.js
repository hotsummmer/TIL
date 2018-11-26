DiContainer = function(){
	if(!(this instanceof DiContainer)) return new DiContainer();
	this.registrations = [];
};
DiContainer.prototype.messages = {
	registerRequresArgs : '이 생성자 함수는 인자가 3개 있어야 합니다 : 문자열, 문자열 배열, 함수'
};
DiContainer.prototype.register = function(name, depedencies, func){
	var ix;
	if(typeof name !== 'string' || !Array.isArray(depedencies) || typeof func !== 'function') throw new Error(this.messages.registerRequresArgs);
	for(ix = 0; ix < depedencies.length; ++ix){
		if(typeof depedencies[ix] !== 'string') throw new Error(this.messages.registerRequresArgs);
	}
	this.registrations[name] = {depedencies: depedencies, func:func};
};
DiContainer.prototype.get = function(name){
	var self = this, registration = this.registrations[name], dependencies = [];
	if(registration === undefined) return registration;
	registration.depedencies.forEach(function(dependencyName){
		var dependency = self.get(dependencyName);
		dependencies.push(dependency === undefined ? undefined : dependency);
	});
	return registration.func.apply(undefined, dependencies);
};