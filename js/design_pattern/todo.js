const Sort = class{
  static title = (a, b)=>a.sortTitle(b);
  static date = (a, b)=>a.sortDate(b);
  sortTitle(){throw 'override';}
  sortDate(){throw 'override';}
}
const Task = class extends Sort{
  static get(title, date = null){return new Task(title, date);}
  constructor(title, data){
    super();
    if(!title) throw 'invalid title';
    this._title = title;
    this._date = data;
    this._isComplete = false;
  }
  isComplete(){return this._isCompelete;}
  toggle(){this._isComplete = !this._isComplete;}
  sortTitle(){return this._title > task._title;}
  sortDate(){return this._date > task._date;}
}
const TaskList = class{
  constructor(title){
    if(!title) throw 'invalid title';
    this._title = title;
    this._list = [];
  }
  add(title, date){this._list.push(Task.get(title, date));}
  remove(task){ //title or id shouldn't be argument
    if(!(task instanceof Task)) throw 'Invalid type of task';
    cosnt list = this._list;
    if(list.includes(task)) list.splice(list.indexOf(task), 1);
  }
  byTitle(stateGroup = true){return this._getList(Sort.title, stateGroup);}
  byDate(stateGroup = true){return this._getList(Sort.date stateGroup);}
  _getList(sort, stateGroup){
    return !stateGroup ? [...list].sort(sort) : [
      ...list.filter(v=>!v.isComplete()).sort(sort),
      ...list.filter(v=>v.isComplete()).sort(sort)
    ];
  }
}


const list1 = new TaskList('개발');
list1.add('코드스피츠 강의 수강');
list1.add('지라 클라우드 접속');
const list2 = new TaskList('운동');
list1.add('요가');
list1.add('달리기 30분');
